package com.abror.loader;


import com.abror.entity.Admin;
import com.abror.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    private final AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            if (init.equalsIgnoreCase("create")) {
                Admin admin=new Admin(895733397L,"START");
                adminRepository.save(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
