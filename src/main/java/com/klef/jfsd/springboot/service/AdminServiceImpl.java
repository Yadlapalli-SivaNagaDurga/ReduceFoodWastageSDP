package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Donor;
import com.klef.jfsd.springboot.model.DonorHistory;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.DonorHistoryRepository;
import com.klef.jfsd.springboot.repository.DonorRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private DonorRepository donorRepository;
   
    @Override
    public Admin validateAdmin(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void updateAdminPassword(String email, String newPassword) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            admin.setPassword(newPassword);
            adminRepository.save(admin);
        }
    }

	@Override
	public List<Donor> viewAllDonors() {
		  return donorRepository.findAll();
	}


	

	
}
