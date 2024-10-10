package trafficsim;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Objects;

public class SoundManager {
	Clip clip;
	Clip driftClip;

	public SoundManager() {
		try {

			AudioInputStream inputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream("/Traffic Sounds - Free Sound Effects - Traffic Sound Clips - Sound Bites.wav")));
			AudioInputStream driftStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream("/drift.wav")));

			clip = AudioSystem.getClip();
			driftClip = AudioSystem.getClip();

			clip.open(inputStream);
			driftClip.open(driftStream);

			driftClip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);

			Thread.sleep(100000000);
		} catch (Exception e) {
			System.out.println("Erreur lors du chargement du son: " + e.getMessage());
		}
	}
}

