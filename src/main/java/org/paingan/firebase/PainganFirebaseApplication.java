package org.paingan.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class PainganFirebaseApplication {

	public static void main(String[] args) {

		SpringApplication.run(PainganFirebaseApplication.class, args);

		FileInputStream serviceAccount;

		try {
			serviceAccount = new FileInputStream(
					"/Users/paulusyansen/workspace-msa/paingan-firebase/src/main/resources/serviceAccountKey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://painganlabs.firebaseio.com").build();

			FirebaseApp.initializeApp(options);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
	}

}
