package com.example.demo.VipUser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/vipUser")
public class VipUserController {

    // UserService dependency injected into UserController
    @Autowired
    private VipUserService vipUserService;

    // Return all VipUsers
    @GetMapping("/all")
    public List<VipUser> getAllVipUsers () {
        return vipUserService.findAllVipUsers();
    }

    // Find VipUser by Id
    @GetMapping("/{id}")
    public Optional<VipUser> findVipUserById (String id) {
        return vipUserService.findVipUserById(id);
    }

    // Find VipUser by Email
    @GetMapping("/email/{email}")
    public Optional<VipUser> findVipUserByEmail (String email) {
        return vipUserService.findVipUserByEmail(email);
    }

    // Create VipUser
    @PostMapping("/createVipUser")
    public ResponseEntity<?> createVipUser (@RequestBody VipUser vipUser, @RequestHeader("Content-Type") String contentType) {
        return VipUserService.createVIPUserWithContentTypeCheck(vipUser, contentType);

    }

    // Count VipUsers by Age
    @GetMapping("/countByAge")
    public long countVipUserByAge () {
        return vipUserService.countVipUserByAge();
    }

    // Update VipUser
    @PutMapping("/{id}")
    public VipUser updateVipUser (@PathVariable String id, @RequestBody VipUser updatedVipUser) {
        return vipUserService.updateVipUser(id, updatedVipUser);
    }

    // Delete VipUser
    @DeleteMapping("/{id}")
    public void deleteVipUser (@PathVariable String id) {
        vipUserService.deleteVipUser(id);
    }
}
