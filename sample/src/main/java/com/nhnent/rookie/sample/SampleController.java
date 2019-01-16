package com.nhnent.rookie.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nhnent.rookie.sample.domain.Sample;
import com.nhnent.rookie.sample.mapper.SampleMapper;

@Controller
@RequestMapping("/samples")
public class SampleController {
	@Autowired
	private SampleMapper sampleMapper;		// SampleController는 SampleMapper에 의존함(연관관계)

	@GetMapping("/{seq}")
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String detail(@PathVariable("seq") Long seq, Model model) {
		Sample sample = sampleMapper.findOne(seq);
		if(sample == null) {
			return "sample/notfound";
		}
		model.addAttribute("detail", sample);
		return "sample/detail";
	}
}
