package com.example.demo.VipUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VipUserService {
    
    // Dependency Injection
    @Autowired
    private static VipUserRepository vipUserRepository;
    
        // Create User with Content-Type Check
        public static ResponseEntity<?> createVIPUserWithContentTypeCheck(VipUser vipUser, String contentType) {
            // Check if the content-type is Application/Json
            if (!"application/json".equals(contentType)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid content type. Expected application/json.");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(createVipUser(vipUser.getName(), vipUser.getAge(), vipUser.getDob(), vipUser.getEmail(), vipUser.getHeight(), vipUser.getWeight(), vipUser.getVipStatus(), vipUser.getIMC()));
                        }
                    }
                
                    // Create
                    public static VipUser createVipUser(String name, Integer age, LocalDate dob, String email, double height, double weight, String vipStatus, double IMC) {
            VipUser vipUser = new VipUser(name, age, dob, email, height, weight, vipStatus, IMC);
            return vipUserRepository.save(vipUser);
    }

    // Read by ID
    public Optional<VipUser> findVipUserById(String id) {
        return vipUserRepository.findById(id);
    }

    // Read All VipUsers
    public List<VipUser> findAllVipUsers() {
        return vipUserRepository.findAll();
    }

    // Find VipUser by Name
    public Optional<VipUser> findVipUserByName(String name) {
        return vipUserRepository.findVipUserByName(name);
    }

    // Find VipUser by Email
    public Optional<VipUser> findVipUserByEmail(String email) {
        return vipUserRepository.findVipUserByEmail(email);
    }

    // Count VipUsers by Age
    public long countVipUserByAge() {
        return vipUserRepository.count();
    }

    // Update VipUser
    public VipUser updateVipUser(String id, VipUser updatedVipUser) {
        return vipUserRepository.findById(id).map(vipUser -> {
            vipUser.setName(updatedVipUser.getName());
            vipUser.setAge(updatedVipUser.getAge());
            vipUser.setDob(updatedVipUser.getDob());
            vipUser.setEmail(updatedVipUser.getEmail());
            vipUser.setHeight(updatedVipUser.getHeight());
            vipUser.setWeight(updatedVipUser.getWeight());
            vipUser.setVipStatus(updatedVipUser.getVipStatus());
            vipUser.setIMC(updatedVipUser.getIMC());
            return vipUserRepository.save(vipUser);
        }).orElseThrow(() -> new RuntimeException("VipUser not found with id: " + id));
    }

    // Delete VipUser
    public void deleteVipUser(String id) {
        vipUserRepository.deleteById(id);
    }
}
