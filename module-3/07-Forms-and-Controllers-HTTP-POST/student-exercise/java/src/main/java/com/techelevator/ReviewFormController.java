package com.techelevator;

import javax.servlet.http.HttpSession;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReviewFormController {

    @Autowired
    private ReviewDao reviewDAO;

    @RequestMapping(path = "/reviewInput", method = RequestMethod.GET)
    public String showReviewInput(){
        return "reviewInput";
    }

    @RequestMapping(path= "reviewInput", method = RequestMethod.POST)
    public String processReviewInput (Review review){
        reviewDAO.save(review);
        review.setDateSubmitted(LocalDateTime.now());
        return "redirect:/";
    }
}