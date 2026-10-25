package helpers;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

import java.io.ByteArrayInputStream;

import static config.ConfigManager.BS_CONFIG;
import static io.restassured.RestAssured.given;

public class AllureAttachments {

    public static void attachVideo(String sessionId) {
        try {
            String videoUrl = Browserstack.videoUrl(sessionId);
            byte[] video = null;
            int maxAttempts = 10; // Увеличили количество попыток
            int waitMs = 15000;   // Ждем по 15 секунд

            for (int i = 0; i < maxAttempts; i++) {
                try {
                    Response response = given()
                            .auth().basic(BS_CONFIG.username(), BS_CONFIG.accessKey())
                            .get(videoUrl);

                    String contentType = response.getContentType();
                    byte[] body = response.asByteArray();

                    // Главная проверка: статус 200, тип видео, и размер больше 10 КБ
                    if (response.statusCode() == 200
                            && contentType != null
                            && contentType.contains("video")
                            && body.length > 10240) {
                        video = body;
                        System.out.println("Video downloaded successfully! Size: " + video.length + " bytes");
                        break;
                    } else {
                        System.out.println("Attempt " + (i + 1) + ": Not a valid video yet. " +
                                "Status: " + response.statusCode() +
                                ", Content-Type: " + contentType +
                                ", Size: " + body.length + " bytes. Waiting...");
                    }
                } catch (Exception e) {
                    System.out.println("Attempt " + (i + 1) + " error: " + e.getMessage());
                }
                Thread.sleep(waitMs);
            }

            if (video != null) {
                Allure.addAttachment("Video", "video/mp4", new ByteArrayInputStream(video), ".mp4");
            } else {
                System.out.println("Could not download video after " + maxAttempts + " attempts. Attaching link.");
                Allure.addAttachment("Video (Link)", "text/plain", videoUrl);
            }
        } catch (Exception e) {
            System.out.println("Error in attachVideo: " + e.getMessage());
        }
    }

    public static void attachScreenshot() {
        new Screenshot().attachScreenshot();
    }
}
