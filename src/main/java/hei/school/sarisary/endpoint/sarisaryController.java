package hei.school.sarisary.endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class sarisaryController {

    @PostMapping("/black-and-white/{id}")
    public ResponseEntity<Void> uploadImage(@PathVariable String id, @RequestBody byte[] imageData) {
        return ResponseEntity.ok().build(); // OK si traitement réussi
    }

    @GetMapping("/black-and-white/{id}")
    public ResponseEntity<TransformationResult> getImageTransformation(@PathVariable String id) {
        String originalUrl = "https://original.url";
        String transformedUrl = "https://transformed.url";

        TransformationResult result = new TransformationResult(originalUrl, transformedUrl);
        return ResponseEntity.ok(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(sarisaryController.class, args);
    }

    static class TransformationResult { 
        private String originalUrl;
        private String transformedUrl;

        public TransformationResult(String originalUrl, String transformedUrl) {
            this.originalUrl = originalUrl;
            this.transformedUrl = transformedUrl;
        }

        // Getters et setters
        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getTransformedUrl() {
            return transformedUrl;
        }

        public void setTransformedUrl(String transformedUrl) {
            this.transformedUrl = transformedUrl;
        }
    }
}

