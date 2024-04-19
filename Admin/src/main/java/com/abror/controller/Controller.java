package com.abror.controller;

import com.abror.payload.AdminPayload;
import com.abror.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final AdminService adminService;

    @PostMapping
    public boolean addAdmin(@RequestBody AdminPayload adminPayload) {
        return adminService.addAdmin(adminPayload);
    }

    @GetMapping("/{adminId}")
    public String getAdminAction(@PathVariable Long adminId) {
        return adminService.getActionById(adminId);
    }

    @PutMapping
    public boolean updateAdmin(@RequestParam("adminId") Long adminId,
                               @RequestParam("action") String action) {
        return adminService.updateAdmin(adminId, action);
    }

}
