package com.valtech.health.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.valtech.health.app.entity.Admin;
import com.valtech.health.app.entity.Ambulance;
import com.valtech.health.app.entity.Doctor;
import com.valtech.health.app.entity.DoctorUser;
import com.valtech.health.app.entity.Hospital;
import com.valtech.health.app.entity.PatientDetails;
import com.valtech.health.app.entity.User;
import com.valtech.health.app.model.DoctorUserModel;
import com.valtech.health.app.model.UserModel;
import com.valtech.health.app.repostitory.DoctorRepository;
import com.valtech.health.app.repostitory.DoctorUserRepository;
import com.valtech.health.app.repostitory.UserRepository;
import com.valtech.health.app.service.AdminServiceImpl;
import com.valtech.health.app.service.AmbulanceService;
import com.valtech.health.app.service.AmbulanceServiceImpl;
import com.valtech.health.app.service.DoctorService;
import com.valtech.health.app.service.DoctorServiceImpl;
import com.valtech.health.app.service.DoctorUserService;
import com.valtech.health.app.service.DoctorUserServiceImpl;
import com.valtech.health.app.service.HospitalService;
import com.valtech.health.app.service.HospitalServiceImpl;
import com.valtech.health.app.service.PatientDetailsService;
import com.valtech.health.app.service.PatientDetailsServiceImpl;
import com.valtech.health.app.service.UserService;
import com.valtech.health.app.service.UserServiceImpl;

@Controller
public class HealthAppController {

	@Autowired
	private UserServiceImpl usi;

	@Autowired
	private UserService us;
	@Autowired
	private UserRepository ur;

	@Autowired
	private DoctorUserRepository dur;
	@Autowired
	private DoctorRepository docr;
	@Autowired
	private DoctorUserService dus;

	@Autowired
	private DoctorUserServiceImpl dusi;

	@Autowired
	private DoctorServiceImpl dsi;
	@Autowired
	private HospitalServiceImpl hsi;

	@Autowired
	private DoctorService ds;
	@Autowired
	private AmbulanceService as;
	@Autowired
	private PatientDetailsService ps;
	@Autowired
	private HospitalService hs;

	@Autowired
	private PatientDetailsServiceImpl pdsi;
	@Autowired
	private AmbulanceServiceImpl asi;
	@Autowired
	private AdminServiceImpl adi;

	/* Home page */
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	/* About Us */
	@GetMapping("/aboutus")
	public String aboutUS() {
		return "aboutus";
	}

	/* Admin Login */
	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}

	/* Admin Login */
	@PostMapping("/adminlogin")
	public String loginAdmin(@ModelAttribute Admin ad, Model model) {
		adi.createAdmin(ad);
		if (ad.getUsername().equals("admin") && ad.getPassword().equals("admin")) {
			return "admindashboard";
		} else {
			model.addAttribute("error", "Invalid Username or Password");
			return "adminlogin";
		}
	}

	/* This method creates Admin DashBoard */
	@GetMapping("/admindashboard")
	public String createnewadmin() {
		return "admindashboard";
	}

	/* This method helps us to check availability of hospital and doctors */
	@GetMapping("/ambulance")
	public String newambulance() {
		return "ambulance";
	}

	/* This method helps us to check availability of hospital and doctors */
	@PostMapping("/ambulance")
	public String ambulance(@ModelAttribute Ambulance a, Model model) {
		asi.createAmbulance(a);
		if ((a.getHospitalAvailability().equals("Yes") && a.getDoctorsAvailability().equals("Yes"))
				&& (a.getBedAvailability().equals("Yes"))) {
			System.out.println(a.getHospitalAvailability());
			model.addAttribute("success", "Login to enter patient details");
			return "login";
		} else {
			model.addAttribute("error", "No Availability");
			return "ambulance";
		}
	}

	/* To add hospital */
	@GetMapping("/hospital")
	public String newhospital() {
		return "hospital";
	}

	/* To add hospital */
	@PostMapping("/hospital")
	public void hospital(@ModelAttribute Hospital h, Model model) {
		hsi.createHospital(h);
		model.addAttribute("success", "Successfully Sent");
	}

	/* This method lists the hospitals */
	@GetMapping("/hospitallist")
	public String hospitallist(Model model) {
		model.addAttribute("h", hs.getAllHospitals());
		return "hospitallist";
	}

	/* This method lists the availability */
	@GetMapping("/ambulancelist")
	public String Commentsambulance(Model model) {
		model.addAttribute("am", as.getAllAmbulance());
		return "ambulancelist";
	}

	/* This method updates the hospital */
	@PostMapping("/updatehospitals/{id}")
	public ModelAndView saveUpdateHospitalDetails(@PathVariable("id") int id, @ModelAttribute Hospital h,
			@RequestParam("submit") String submit) {
		ModelAndView view = new ModelAndView("/hospitallist");
		if (submit.equals("Cancel")) {
			view.addObject("h", hs.getAllHospitals());
			return view;
		}
		hs.updateHospitalDetails(h);
		view.addObject("h", hs.getAllHospitals());
		return view;
	}

	/* This method updates the hospital */
	@GetMapping("/updatehospitals/{id}")
	public String updateHospitalDetails(@PathVariable("id") int id, Model model) {
		model.addAttribute("h", hs.getHospitalById(id));
		return "updatehospital";
	}

	/* This method displays the nurse home page */
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	/* Login Page for Nurse */
	@PostMapping("/login")
	public String loginUser(@ModelAttribute UserModel userModel, @RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {
		String url;
		User u = null;
		User u1 = null;
		try {
			u = ur.findByUsername(username);
			u1 = ur.findByPassword(password);
		} catch (Exception e) {
			System.out.println("User not found !!!");

		}
		if (u != null && u1 != null) {
			model.addAttribute("username", username);
			int id = us.getIdbyUsername((userModel.getUsername()));
			url = "redirect:/dashboard/" + id;
			return url;
		}
		model.addAttribute("error", "Entered username or password are not correct");
		return "login";
	}

	/* Login Page for Nurse */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/* Register Page for Nurse */
	@PostMapping("/register")
	public String registerUser(@RequestParam("email") String email, @Valid @ModelAttribute User u,
			@ModelAttribute UserModel userModel, Model model, BindingResult result) {
		User u1 = null;
		try {

			u1 = ur.findByEmail(email);
		} catch (Exception e) {
			System.out.println("User already registered !!!");
		}
		if (u1 != null) {
			model.addAttribute("error", "User Already Registered");
			return "register";
		}
		if (userModel.getPassword().equals(userModel.getConfirmpassword())) {
			usi.createUser(u);
			return "login";
		} else {
			model.addAttribute("error", "Password and Confirm Password doesnot match");
			return "register";
		}
	}

	/* Register Page for Nurse */
	@GetMapping("/register")
	public String register(@ModelAttribute User u) {
		return "register";
	}

	/* Dash-Board For Nurse */
	@GetMapping("/dashboard/{id}")
	public String createnew1(@PathVariable("id") int id, ModelMap model) {
		ModelAndView view = new ModelAndView("dashboard");
		User u = us.getUsername(id);
		model.addAttribute("add", u.getName());
		return "dashboard";
	}

	/* This method helps to send patient details */
	@GetMapping("/patientdetails")
	public String newpatientdetails() {
		return "patientdetails";
	}

	/* This method helps to send patient details */
	@PostMapping("/patientdetails")
	public void patientdetails(@ModelAttribute PatientDetails p, Model model) {

		model.addAttribute("name", p.getName());

		if (dus.findByName(p.getDoctorsname()) == true) {
			pdsi.createPatientDetails(p);
			model.addAttribute("success", "Successfully Sent");
		} else {
			model.addAttribute("error", "Doctor is not available");
		}
	}

	/* This method helps to list the patient details */
	@GetMapping("/list")
	public String list(Model model) {

		model.addAttribute("p", ps.getAllPatientDetails());
		return "list";
	}

	/* This method helps to update the patient details */
	@PostMapping("/updatePatientDetails/{id}")
	public ModelAndView saveUpdatePatientDetails(@PathVariable("id") int id, @ModelAttribute PatientDetails p,
			@RequestParam("submit") String submit) {
		ModelAndView view = new ModelAndView("/list");
		if (submit.equals("Cancel")) {
			view.addObject("p", ps.getAllPatientDetails());
			return view;
		}
		ps.updatePatientsDetails(p);
		view.addObject("p", ps.getAllPatientDetails());
		return view;
	}

	/* This method helps to update the patient details */
	@GetMapping("/updatePatientDetails/{id}")
	public String updatePatientsDetails(@PathVariable("id") int id, Model model) {
		model.addAttribute("p", ps.getPatientById(id));
		return "updatePatientDetails";
	}

	/* Doctor Home Page */
	@GetMapping("/doctorhome")
	public String doctorhome() {
		return "doctorhome";
	}

	/* Doctor Login Page */
	@PostMapping("/doctorlogin")
	public String doctorLoginUser(@ModelAttribute DoctorUserModel doctorUserModel,
			@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		String url;
		DoctorUser du = null;
		DoctorUser du1 = null;
		try {
			du = dur.findByUsername(username);
			du1 = dur.findByPassword(password);
		} catch (Exception e) {
			System.out.println("User not found !!!");
		}
		if (du != null && du1 != null) {
			model.addAttribute("username", username);
			int id = dus.getIdbyUsername((doctorUserModel.getUsername()));
			url = "redirect:/doctordashboard/" + id;
			return url;
		}
		model.addAttribute("error", "Entered username or password are not correct");
		return "doctorlogin";

	}

	/* Doctor Login Page */
	@GetMapping("/doctorlogin")
	public String doctorLogin() {
		return "doctorlogin";
	}

	/* Doctor Register Page */
	@PostMapping("/doctorregister")
	public String doctorRegisterUser(@RequestParam("email") String email, @Valid @ModelAttribute DoctorUser u,
			@ModelAttribute DoctorUserModel doctorUserModel, Model model, BindingResult result) {

		DoctorUser d = null;

		try {

			d = dur.findByEmail(email);
		} catch (Exception e) {
			System.out.println("User already registered !!!");
		}

		if (d != null) {
			model.addAttribute("error", "User Already Registered");
			return "doctorregister";
		}

		if (doctorUserModel.getPassword().equals(doctorUserModel.getConfirmpassword())) {
			dusi.createDoctorUser(u);
			return "doctorlogin";

		} else {
			model.addAttribute("error", "Password and Confirm Password doesnot match");
			return "doctorregister";
		}

	}

	/* Doctor Register Page */
	@GetMapping("/doctorregister")
	public String doctorRegister(@ModelAttribute DoctorUser u) {
		return "doctorregister";

	}

	/* Dash-Board For Doctor */
	@GetMapping("/doctordashboard/{id}")
	public String createnew(@PathVariable("id") int id, ModelMap model) {
		ModelAndView view = new ModelAndView("doctordashboard");
		DoctorUser u = dus.getUsername(id);
		// System.out.println(u);
		model.addAttribute("add", u.getName());

		return "doctordashboard";
	}

	/* This method helps to send doctor comments */
	@GetMapping("/doctor")
	public String newdoctordetails() {
		return "doctor";
	}

	/* This method helps to send doctor comments */
	@PostMapping("/doctor")
	public void doctorPatientdetails(@ModelAttribute Doctor d, Model model) {

		if (dus.findByName(d.getDoctorsname()) == true) {
			dsi.createDoctor(d);
			model.addAttribute("success", "Successfully Sent");
		} else {

			model.addAttribute("error", "Invalid Doctor Name");
		}

	}

	/* This method helps to list the doctor comments */
	@GetMapping("/doctorlist")
	public String doctorList(Model model) {

		model.addAttribute("d", ds.getAllDoctorComments());

		return "doctorlist";
	}

	/* This method helps to update the doctor comments */
	@PostMapping("/updateDoctorComments/{id}")
	public ModelAndView saveUpdateDoctorComments(@PathVariable("id") int id, @ModelAttribute Doctor d,
			@RequestParam("submit") String submit) {
		ModelAndView view = new ModelAndView("/doctorlist");
		if (submit.equals("Cancel")) {
			view.addObject("d", ds.getAllDoctorComments());
			return view;
		}

		ds.updateDoctorComments(d);
		view.addObject("d", ds.getAllDoctorComments());
		return view;

	}

	/* This method helps to update the doctor comments */
	@GetMapping("/updateDoctorComments/{id}")
	public String updateDoctorComments(@PathVariable("id") int id, Model model) {
		model.addAttribute("d", ds.getDoctorCommentById(id));

		return "updateDoctorComments";
	}

	/* Comment List */
	@GetMapping("/commentlist") // staff
	public String Comments(Model model) {
		model.addAttribute("d", ds.getAllDoctorComments());
		return "commentlist";
	}

	/* Logout */
	@GetMapping("/logout")
	public String logout() {
		return "index";
	}

}
