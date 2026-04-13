package vn.iotstar.controllers.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.iotstar.entity.Branch;
import vn.iotstar.entity.MilkTea;
import vn.iotstar.services.IBranchMilkTeaService;
import vn.iotstar.services.IIncomeService;


@Controller
public class WHomeController {
	
	@Autowired
	private IIncomeService iIncomeService;
	
	@Autowired IBranchMilkTeaService branchMilkTeaService;
	
	@GetMapping({"/", "/web/home"})
	public String index(Model model)
	{
		try {
			List<Branch> list = iIncomeService.getTop4BranchesByTotalValue();
			model.addAttribute("listBranch", list);
		} catch (Exception e) {
			model.addAttribute("listBranch", List.of());
		}
		try {
			List<MilkTea> listMilkTea = branchMilkTeaService.getTop3MilkTea();
			model.addAttribute("listMilkTea", listMilkTea);
		} catch (Exception e) {
			model.addAttribute("listMilkTea", List.of());
		}
		return "web/home";
	}

}