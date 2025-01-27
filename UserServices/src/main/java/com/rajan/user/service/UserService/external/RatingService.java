/**
 * 
 */
package com.rajan.user.service.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.rajan.user.service.UserService.entities.Rating;

/**
 * com.rajan.user.service.UserService.external
 *@author Rajan kumar
 */
@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    //get

    //POST

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}