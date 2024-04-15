package com.abror.service;

import com.abror.entity.Admin;
import com.abror.payload.AdminPayload;
import com.abror.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    private final AdminRepository adminRepository;

    public boolean addAdmin(AdminPayload adminPayload) {
        try {
            Admin admin = Admin.builder()
                    .id(adminPayload.getId())
                    .action(adminPayload.getAction())
                    .build();

            adminRepository.save(admin);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add admin - {}" + e.getMessage());
        }
        return false;
    }

    public String getActionById(Long id) {
        try {
            Admin admin = adminRepository.getById(id);
            return admin.getAction();
        } catch (Exception e) {
            log.error("Exception is in the method of get action by id - {}" + e.getMessage());
        }
        return "-1";
    }

    public boolean updateAdmin(Long id, String newAction) {
        try {
            if (adminRepository.existsById(id)) {
                Admin admin = Admin.builder()
                        .id(id)
                        .action(newAction)
                        .build();

                adminRepository.save(admin);
                return true;
            } else
                return false;
        } catch (Exception e) {
            log.error("Exception is in the method of update admin - {}" + e.getMessage());
        }
        return false;
    }

}
