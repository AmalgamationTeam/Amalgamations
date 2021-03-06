package util;

import amalgamation.abilities.Ability;
import amalgamation.parts.Arm;
import amalgamation.parts.Body;
import amalgamation.parts.Head;
import amalgamation.parts.Leg;
import amalgamation.parts.Part;
import amalgamation.parts.Slot;
import java.util.Random;
/**
 * Parts is a utility class that contains useful Part related functions and
 * constants.
 * 
 * All methods in this class are class functions, so they can be called without
 * an instance of this class.
 * 
 * @author Caleb Rush
 */
public class Parts {
    // File extension for Part files.
    public static final String  PARTS_FILE_EXT  = ".part";
    // Directories for saved Part file folders
    public static final String  PARTS_RES_DIR   = "res/part/";
    public static final String  ARMS_RES_DIR    = "res/part/Arms/";
    public static final String  BODIES_RES_DIR  = "res/part/Bodies/";
    public static final String  HEADS_RES_DIR   = "res/part/Heads/";
    public static final String  LEGS_RES_DIR    = "res/part/Legs/";
    // Directories for Part image files
    public static final String  PARTS_IMG_DIR   = "res/img/Parts/";
    public static final String  ARMS_IMG_DIR    = "res/img/Parts/Arms/";
    public static final String  BODIES_IMG_DIR  = "res/img/Parts/Bodies/";
    public static final String  HEADS_IMG_DIR   = "res/img/Parts/Heads/";
    public static final String  LEGS_IMG_DIR    = "res/img/Parts/Legs/";
    // Identifiers for Part types.
    public static final int     TYPE_PART       = 0;
    public static final int     TYPE_ARM        = 1;
    public static final int     TYPE_BODY       = 2;
    public static final int     TYPE_HEAD       = 3;
    public static final int     TYPE_LEG        = 4;
    
    /**
     * Deletes the Part file from the appropriate Part resource directory.
     * 
     * This delete operation cannot be reversed and does not prompt the user,
     * so be sure to warn the user before performing this operation.
     * 
     * @param type the type of Part. This is important,
     *             as this will decide which subfolder to search for the Part
     *             file. The values to be used for this parameter are defined as 
     *             constants in this class called TYPE_XXXX. Be sure to use
     *             the class constants and not the actual values, as the values
     *             could theoretically change.
     * @param partFileName the name of the Part file to be deleted.
     * @throws IllegalArgumentException if the type is invalid
     */
    public static void delete(int type, String partFileName) 
            throws IllegalArgumentException {
        String resDirectory = PARTS_RES_DIR;
        
        // Determine the type of the Part.
        switch(type) {
            case TYPE_ARM:
                resDirectory = ARMS_RES_DIR;
                break;
                
            case TYPE_BODY:
                resDirectory = BODIES_RES_DIR;
                break;
                
            case TYPE_HEAD:
                resDirectory = HEADS_RES_DIR;
                break;
                
            case TYPE_LEG:
                resDirectory = LEGS_RES_DIR;
                break;
                
            default:
                throw new IllegalArgumentException(
                        "Invalid Part type: " + type);
        }
        
        // Delete the file.
        new java.io.File(resDirectory + partFileName + PARTS_FILE_EXT).delete();
    }
    
    /**
     * Loads a Part from the given file.
     * 
     * Although the return type of this method is a Part, the returned value
     * should be cast to the appropriate Part subclass.
     * 
     * @param type the type of Part to load the Part as. This is important,
     *             as this will decide which subfolder to search for the Part
     *             file. The values to be used for this parameter are defined as 
     *             constants in this class called TYPE_XXXX. Be sure to use
     *             the class constants and not the actual values, as the values
     *             could theoretically change.
     * @param partFileName the name of the Part file to be loaded.
     * @return the Part loaded from the file
     */
    public static Part load(int type, String partFileName) 
            throws IllegalArgumentException {
        String resDirectory = PARTS_RES_DIR;
        
        // Determine the type of the Part.
        switch(type) {
            case TYPE_ARM:
                resDirectory = ARMS_RES_DIR;
                break;
                
            case TYPE_BODY:
                resDirectory = BODIES_RES_DIR;
                break;
                
            case TYPE_HEAD:
                resDirectory = HEADS_RES_DIR;
                break;
                
            case TYPE_LEG:
                resDirectory = LEGS_RES_DIR;
                break;
                
            default:
                throw new IllegalArgumentException(
                        "Invalid Part type: " + type);
        }
        
        // Attempt to load the file.
        Part part;
        try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(
                    new java.io.FileInputStream(
                            resDirectory + partFileName + PARTS_FILE_EXT
                    ))) {
            // Load the part from the file.
            part = (Part)in.readObject();
        } catch (java.io.IOException e) {
            throw new IllegalArgumentException(String.format(
                    "The PART file %s does not exist in the %s directory", 
                    partFileName, resDirectory));
        } catch (ClassNotFoundException e) {
            // If the class is not found, something is seriously wrong.
            e.printStackTrace();
            return null;
        }
        
        return part;
    }
    
    /**
     * Loads all the names of the Part files in the given directory.
     * 
     * The names returned do not contain the absolute path or the actual file
     * extension. They are returned such that each Part can be loaded by simply
     * passing the name to the load method.
     * 
     * @param dirPath the path to the directory to retrieve the name of the Part
     *                files from
     * @return an array of Strings containing the names of all of the Part files
     *         found in the directory. The names do not contain either the
     *         directory or the Part file extension.
     */
    public static String[] getPartNames(String dirPath) { 
        // Load the directory. 
        java.io.File directory = new java.io.File(dirPath); 
          
        // Load only files with the .part file extension. 
        String[] fileNames = directory.list((dir, name) -> 
                PARTS_FILE_EXT.equals( 
                    name.substring(name.lastIndexOf("."))) 
        ); 
          
        // Remove the file extensions from the file names. 
        String[] names = new String[fileNames.length]; 
        for (int i = 0; i < names.length; i++) { 
            // Retrieve the last index of a period in the filename. 
            int index = fileNames[i].lastIndexOf('.'); 
            // Set the arm name to everything before the period. 
            names[i] = fileNames[i].substring(0, index); 
        } 
          
        return names; 
    }
    
    /**
     * Retrieves all the Arms saved in Part files in the specified directory.
     * 
     * @param dirPath the path of the directory to load all of the Arms from
     * @return an array of all the Arms loaded from the directory.
     * @throws java.io.IOException if the directory pointed to by dirPath does
     *                             not exist.
     */
    public static Arm[] getArms(String dirPath) throws java.io.IOException {
        // Filter out the Arms from the list of Parts in this directory.
        return java.util.stream.Stream.of(getParts(dirPath))
                    .filter(part -> part instanceof Arm)
                    .toArray(Arm[]::new);
    }
    
    /**
     * Retrieves all the Bodies saved in Part files in the specified directory.
     * 
     * @param dirPath the path of the directory to load all of the Bodies from
     * @return an array of all the Bodies loaded from the directory.
     * @throws java.io.IOException if the directory pointed to by dirPath does
     *                             not exist.
     */
    public static Body[] getBodies(String dirPath) throws java.io.IOException {
        // Filter out the Arms from the list of Parts in this directory.
        return java.util.stream.Stream.of(getParts(dirPath))
                    .filter(part -> part instanceof Body)
                    .toArray(Body[]::new);
    }
    
    /**
     * Retrieves all the Heads saved in Part files in the specified directory.
     * 
     * @param dirPath the path of the directory to load all of the Heads from
     * @return an array of all the Heads loaded from the directory.
     * @throws java.io.IOException if the directory pointed to by dirPath does
     *                             not exist.
     */
    public static Head[] getHeads(String dirPath) throws java.io.IOException {
        // Filter out the Arms from the list of Parts in this directory.
        return java.util.stream.Stream.of(getParts(dirPath))
                    .filter(part -> part instanceof Head)
                    .toArray(Head[]::new);
    }
    
    /**
     * Retrieves all the Legs saved in Part files in the specified directory.
     * 
     * @param dirPath the path of the directory to load all of the Legs from
     * @return an array of all the Legs loaded from the directory.
     * @throws java.io.IOException if the directory pointed to by dirPath does
     *                             not exist.
     */
    public static Leg[] getLegs(String dirPath) throws java.io.IOException {
        // Filter out the Arms from the list of Parts in this directory.
        return java.util.stream.Stream.of(getParts(dirPath))
                    .filter(part -> part instanceof Leg)
                    .toArray(Leg[]::new);
    }
    
    /**
     * Retrieves all the Parts saved in Part files in the specified directory.
     * 
     * The Part array returned by this method is not safe to cast to a specific
     * type of Part array, even if one of the Part resource directories defined
     * in this class are used. If a more specific type of part is required, use
     * the appropriate getXXXXs method.
     * 
     * @param dirPath the path of the directory to load all of the Parts from
     * @return an array of all the Parts loaded from the directory.
     * @throws java.io.IOException if the directory pointed to by dirPath does
     *                             not exist.
     * @see Parts#getArms getArms
     * @see Parts#getBodies getBodies
     * @see Parts#getHeads getHeads
     * @see Parts#getLegs getLegs
     */
    public static Part[] getParts(String dirPath) throws java.io.IOException {
        // Load the directory.
        java.io.File directory = new java.io.File(dirPath);
        
        // Load only files with the .part file extension.
        java.io.File[] files = directory.listFiles((dir, name) ->
                PARTS_FILE_EXT.equals( 
                    name.substring(name.lastIndexOf(".")))
        );
        
        // Load the Parts from each file.
        Part[] parts = new Part[files.length];
        for (int i = 0; i < files.length; i++) {
            try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(
                        new java.io.FileInputStream(files[i]))) {
                parts[i] = (Part)in.readObject();
            } catch (ClassNotFoundException e) {
                // If the class is not found, something is seriously wrong.
                e.printStackTrace();
                return null;
            }   
        }
        
        return parts;
    }
    
    /**
     * Generates a random Body using all of the Parts available in the Parts
     * resource directory.
     * 
     * @return the randomized Body
     * @throws java.io.IOException If any of the Part resource directories
     *                             cannot be accessed due to invalid permissions
     *                             or the directories not existing.
     * @throws IllegalArgumentException If any of the directories do not contain
     *                                  any parts.
     */
    public static Body randomBody() 
            throws java.io.IOException, IllegalArgumentException {
        return randomBody(getArms(ARMS_RES_DIR), getBodies(BODIES_RES_DIR), 
                getHeads(HEADS_RES_DIR), getLegs(LEGS_RES_DIR));
    }
    
    /**
     * Generates a random Body using the given Parts.
     * 
     * The Body will already have its Slots set to randomized Parts.
     * 
     * @param arms the Arms the randomized Body can choose from
     * @param bodies the Bodies the randomized Body can be
     * @param heads the Heads the randomized Body can choose from
     * @param legs the Legs the randomized Body can choose from
     * @return the randomized Body
     * @throw IllegalArgumentException if any of the arrays of parts are null or
     *                                 empty
     */
    public static Body randomBody(Arm[] arms, Body[] bodies, Head[] heads, 
            Leg[] legs) throws IllegalArgumentException {
        // Ensure that each of the arrays are not null or empty.
        if (arms == null)
            throw new IllegalArgumentException(
                    "The array of Arms cannot be null!");
        else if (arms.length == 0)
            throw new IllegalArgumentException(
                    "The array of Arms cannot be empty!");
        if (bodies == null)
            throw new IllegalArgumentException(
                    "The array of Bodies cannot be null!");
        else if (bodies.length == 0)
            throw new IllegalArgumentException(
                    "The array of Bodies cannot be empty!");
        if (heads == null)
            throw new IllegalArgumentException(
                    "The array of Heads cannot be null!");
        else if (heads.length == 0)
            throw new IllegalArgumentException(
                    "The array of Heads cannot be empty!");
        if (legs == null)
            throw new IllegalArgumentException(
                    "The array of Legs cannot be null!");
        else if (legs.length == 0)
            throw new IllegalArgumentException(
                    "The array of Legs cannot be empty!");
        
        // Create a random number generator.
        Random rand = new Random();
        
        // Choose a random body.
        Body body = bodies[rand.nextInt(bodies.length)];
        
        // Iterate through the body's Arm slots.
        for (Slot s : body.getArmSlots())
            // Set a random arm to the slot.
            s.setPart(arms[rand.nextInt(arms.length)]);
        
        // Iterate through the body's Head slots.
        for (Slot s : body.getHeadSlots())
            // Set a random head to the slot.
            s.setPart(heads[rand.nextInt(heads.length)]);
        
        // Iterate through the body's Leg slots.
        for (Slot s : body.getLegSlots())
            // Set a random leg to the slot.
            s.setPart(legs[rand.nextInt(legs.length)]);
        
        return body;
    }

    /**
     * Creates and saves a Part instance with the given characteristics to
     * a resource file, allowing it to later be loaded with the load method.
     * 
     * This method also copies the given image into the image resources folder
     * to be referenced and used by the saved Part.
     * 
     * @param type the type of Part to save the given Part as. This is important,
     *             as this will decide the real type of the saved Part and
     *             determines where the image and Part resource files will be
     *             saved. The values to be used for this parameter are defined as 
     *             constants in this class called TYPE_XXXX. Be sure to use
     *             the class constants and not the actual values, as the values
     *             could theoretically change.
     * @param imageFile the image file to be used as the Part's image.
     * @param name the name of the saved Part.
     * @param pivotX the X position of the saved Part's pivot point. If the type
     *               of Part is Body, this will not be used.
     * @param pivotY the Y position of the saved Part's pivot point. If the type
     *               of Part is Body, this will not be used.
     * @param baseHealth the base Health of the saved Part.
     * @param baseAttack the base Attack of the saved Part.
     * @param baseDefense the base Defense of the saved Part.
     * @param baseSpeed the base Speed of the saved Part.
     * @param arms the array of Arm Slots on the Part if the Part is a Body. If
     *             the type of Part is not Body, this will not be used, and can
     *             therefore be null.
     * @param heads the array of Head Slots on the Part if the Part is a Body. 
     *              If the type of Part is not Body, this will not be used, and 
     *              can therefore be null.
     * @param legs the array of Leg Slots on the Part if the Part is a Body. If
     *             the type of Part is not Body, this will not be used, and can
     *             therefore be null.
     * @param abilities the array of Abilities that the Part provides.
     * @return the error message if the save failed. If the save was successful,
     *         null is returned.
     * @throws IllegalArgumentException if the type is invalid
     */
    public static String save(int type, java.io.File imageFile, String name, 
            int pivotX, int pivotY, 
            int baseHealth, int baseAttack, int baseDefense, int baseSpeed,
            Slot<Arm>[] arms, Slot<Head>[] heads, Slot<Leg>[] legs, 
            Ability[] abilities) throws IllegalArgumentException {
        Part part = null;
        String imageDirectory = PARTS_IMG_DIR;
        String resDirectory = PARTS_RES_DIR;
        
        // Determine the type of the Part.
        switch(type) {
            case TYPE_ARM:
                part = new Arm(name, imageFile.getName(),
                        baseHealth, baseAttack, baseDefense, baseSpeed,
                        pivotX, pivotY, abilities);
                imageDirectory = ARMS_IMG_DIR;
                resDirectory = ARMS_RES_DIR;
                break;
                
            case TYPE_BODY:
                part = new Body(name, imageFile.getName(),
                        baseHealth, baseAttack, baseDefense, baseSpeed,
                        arms, heads, legs, abilities);
                imageDirectory = BODIES_IMG_DIR;
                resDirectory = BODIES_RES_DIR;
                break;
                
            case TYPE_HEAD:
                part = new Head(name, imageFile.getName(),
                        baseHealth, baseAttack, baseDefense, baseSpeed,
                        pivotX, pivotY, abilities);
                imageDirectory = HEADS_IMG_DIR;
                resDirectory = HEADS_RES_DIR;
                break;
                
            case TYPE_LEG:
                part = new Leg(name, imageFile.getName(),
                        baseHealth, baseAttack, baseDefense, baseSpeed,
                        pivotX, pivotY, abilities);
                imageDirectory = LEGS_IMG_DIR;
                resDirectory = LEGS_RES_DIR;
                break;
                
            default:
                throw new IllegalArgumentException(
                        "Invalid Part type: " + type);
        }
        
        // Attempt to create the resource file.
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream(
                            resDirectory + name + PARTS_FILE_EXT))) {
            // Write the created Part to the file.
            out.writeObject(part);
        } catch (java.io.IOException e) {
            return "Could not save the Part to a resource file. Please make "
                    + "sure the directory " + resDirectory + " exists.";
        }
        
        // Attempt to copy the image file.
        try {
            java.nio.file.Files.copy(
                    // Copy the image file...
                    java.nio.file.Paths.get(imageFile.getAbsolutePath()),
                    // ... into the image folder.
                    java.nio.file.Paths.get(imageDirectory, imageFile.getName())
            );
        } catch (java.io.IOException e) {
            return "The image file " + imageFile.getAbsolutePath() + " already"
                    + " exists. The Part was saved successfully, but the image"
                    + " it uses may not be correct.";
        }
        
        return null;
    }
}
