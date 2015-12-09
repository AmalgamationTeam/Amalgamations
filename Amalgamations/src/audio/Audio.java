package audio;

// Changed

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Audio can play a sound either once or continuously in a loop. The volume
 * of the Audio can also be set.
 * 
 * @author cir5274, jjl5451
 */
public class Audio {
    // The list of master gain values for each volume level.
    private final static float[] GAINS = { -20f, -10f, 0f };
    // The volume level to be used for turning the volume to max.
    public final static int VOLUME_MAX = GAINS.length;
    // The volume level to be used for turning the volume to min.
    public final static int VOLUME_MIN = 1;
    
    // The clip that plays the audio.
    private Clip clip;
    // The current master gain ("volume") of the audio.
    private int volume = VOLUME_MIN;
    
    /**
     * Sets the audio to play the audio file pointed to by the audioFilePath.
     * 
     * @param audioFilePath the path of the audio file to be played
     * @throws IOException if the path does not point to an actual file
     * @throws UnsupportedAudioFileException if the file format is not supported
     *                                      by Java.
     * @throws LineUnavailableException if the system hardware cannot play the
     *                                 requested audio
     */
    public void setAudio(String audioFilePath) throws IOException,
            UnsupportedAudioFileException,
            LineUnavailableException {
        // Create an AudioInputStream from the file pointed to by the file path.
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                new File(audioFilePath));
        
        // Close the previous clip if it existed.
        if (clip != null)
            clip.close();
        
        // Create a new clip that plays the newly made audio stream.
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        
        // Set the clip's volume.
        setVolume(volume);
    }
    
    /**
     * Sets the volume of the Audio. 
     * <p>
     * To avoid distortion, the Audio's max volume is actually the natural 
     * volume of the audio track. All lower volumes simply set the audio line's
     * master gain to a negative value of varying magnitude.
     * </p>
     * <p>
     * The Audio does not have to be specified to use this method. The volume
     * set using this method will be remembered and set each time the Audio is
     * changed to ensure that the volume is consistent.
     * </p>
     * @param volume the volume level to set the Audio's volume to. Use 
     *               Audio.VOLUME_MAX to set the volume to its highest setting
     *               or Audio.VOLUME_MIN to set it to its lowest. If this volume
     *               is higher than Audio.VOLUME_MAX, Audio.VOLUME_MAX will be
     *               used instead. If the volume is less than Audio.VOLUME_MIN,
     *               the master gain will be set to its lowest possible value
     *               (likely rendering the audio completely mute).
     */
    public void setVolume(int volume) {
        // If the volume is greater than the max, set it to the max.
        if (volume > VOLUME_MAX)
            volume = VOLUME_MAX;
        
        // Save the volume value.
        this.volume = volume;
        
        // Change the gain of the clip if it exists.
        if (clip != null) {
            // Retrieve the control for the clip's master gain.
            FloatControl control = (FloatControl)
                    clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Set the master gain.
            if (volume < VOLUME_MIN)
                control.setValue(control.getMinimum());
            else
                control.setValue(GAINS[volume - 1]);
        }
    }
    
    /**
     * Plays the current audio once without looping.
     */
    public void play() {
        if (clip != null)
            clip.start();
    }
    
    /**
     * Plays the current audio and loops indefinitely.
     */
    public void loop() {
        if (clip != null)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /**
     * Stops the audio playback.
     */
    public void stop() {
        if (clip != null)
            clip.stop();
    }
}
