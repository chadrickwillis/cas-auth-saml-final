 
package gov.sec.cas.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chadr
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping("/welcome")
    public ResponseEntity<String> getUser() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "You're In!");
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }
}

