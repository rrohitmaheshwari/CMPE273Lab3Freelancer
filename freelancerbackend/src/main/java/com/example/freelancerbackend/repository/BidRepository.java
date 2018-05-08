package com.example.freelancerbackend.repository;


import com.example.freelancerbackend.entity.Bids;
import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BidRepository extends CrudRepository<Bids, Long>{

    Bids findByUserEntityAndProjectEntity(Users user, Projects project);
}
