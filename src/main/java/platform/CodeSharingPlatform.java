package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    private CodeService codeService;

    public CodeSharingPlatform(@Autowired CodeService codeService) {
        this.codeService = codeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/api/code")
    public ResponseEntity<Code> getCodeInJson() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Typ", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(codeService.getCodeById(1).get());
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<List<Code>> getLatestCode(Model model) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Typ", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(codeService.getLatestTenCodes());
    }

    @PostMapping("/api/code/new")
   public ResponseEntity<String> changeCode(@RequestBody Code code){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Typ", "application/json");
        code.setDate(LocalDateTime.now());
        Code codeInDb = codeService.addCode(code);

        return  ResponseEntity.status(200)
                .body("{ \"id\" : \"" + codeInDb.getId() + "\" }");

    }

    @GetMapping("api/code/{N}")
    public ResponseEntity<Code> getCodeByNumber(@PathVariable("N") long number) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Typ", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(codeService.getCodeById(number).get());
    }


}
