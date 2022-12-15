package com.valtech.health.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.valtech.health.app.entity.Doctor;
import com.valtech.health.app.entity.DoctorUser;
import com.valtech.health.app.entity.Hospital;
import com.valtech.health.app.entity.PatientDetails;
import com.valtech.health.app.entity.User;
import com.valtech.health.app.repostitory.DoctorRepository;
import com.valtech.health.app.repostitory.DoctorUserRepository;
import com.valtech.health.app.repostitory.HospitalRepository;
import com.valtech.health.app.repostitory.PatientDetailsRepository;
import com.valtech.health.app.repostitory.UserRepository;
import com.valtech.health.app.service.DoctorServiceImpl;
import com.valtech.health.app.service.DoctorUserServiceImpl;
import com.valtech.health.app.service.HospitalServiceImpl;
import com.valtech.health.app.service.PatientDetailsServiceImpl;
import com.valtech.health.app.service.UserServiceImpl;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class HealthAppApplicationTests {
	@Autowired
	private MockMvc mvc;

	/* Testing for home page */
	@Test
	@WithAnonymousUser
	void testIndexWithAnonymous() throws Exception {
		mvc.perform(get("/index")).andExpect(status().isOk());
	}

	/* Testing for about us page */
	@Test
	@WithAnonymousUser
	void testAboutUsWithAnonymous() throws Exception {
		mvc.perform(get("/aboutus")).andExpect(status().isOk());
	}

	/* Testing for home page */
	@Test
	@WithAnonymousUser
	void testHomeWithAnonymous() throws Exception {
		mvc.perform(get("/home")).andExpect(status().isOk());
	}

	/* Testing for doctor home page */
	@Test
	@WithAnonymousUser
	void testDoctorHomeWithAnonymous() throws Exception {
		mvc.perform(get("/doctorhome")).andExpect(status().isOk());
	}

	/* Testing for login page */
	@Test
	@WithAnonymousUser
	void testLoginWithAnonymous() throws Exception {
		mvc.perform(get("/login")).andExpect(status().isOk());
	}

	/* Testing for doctor login page */
	@Test
	@WithAnonymousUser
	void testDoctorLoginHomeWithAnonymous() throws Exception {
		mvc.perform(get("/doctorlogin")).andExpect(status().isOk());
	}

	/* Testing for register page */
	@Test
	@WithAnonymousUser
	void testRegisterWithAnonymous() throws Exception {
		mvc.perform(get("/register")).andExpect(status().isOk());
	}

	/* Testing for doctor register page */
	@Test
	@WithAnonymousUser
	void testDoctorRegisterWithAnonymous() throws Exception {
		mvc.perform(get("/doctorregister")).andExpect(status().isOk());
	}

	/* Testing for patient details page */
	@Test
	@WithAnonymousUser
	void testPatientDetailsWithAnonymous() throws Exception {
		mvc.perform(get("/patientdetails")).andExpect(status().isOk());
	}

	/* Testing for doctor page */
	@Test
	@WithAnonymousUser
	void testDoctorsWithAnonymous() throws Exception {
		mvc.perform(get("/doctor")).andExpect(status().isOk());
	}

	/* Testing for nurse list page */
	@Test
	@WithAnonymousUser
	void testListWithAnonymous() throws Exception {
		mvc.perform(get("/list")).andExpect(status().isOk());
	}

	/* Testing for doctor list page */
	@Test
	@WithAnonymousUser
	void testDoctorListWithAnonymous() throws Exception {
		mvc.perform(get("/doctorlist")).andExpect(status().isOk());
	}

	/* Testing for doctor's comment page */
	@Test
	@WithAnonymousUser
	void testCommentList() throws Exception {
		mvc.perform(get("/commentlist")).andExpect(status().isOk());
	}

	/* Testing for admin dashboard page */
	@Test
	@WithAnonymousUser
	void testAdminDashboardWithAnonymous() throws Exception {
		mvc.perform(get("/admindashboard")).andExpect(status().isOk());
	}

	/* Testing for admin login page */
	@Test
	@WithAnonymousUser
	void testAdminLoginWithAnonymous() throws Exception {
		mvc.perform(get("/adminlogin")).andExpect(status().isOk());
	}

	/* Testing for ambulance home page */
	@Test
	@WithAnonymousUser
	void testAmbulanceWithAnonymous() throws Exception {
		mvc.perform(get("/ambulance")).andExpect(status().isOk());
	}

	/* Testing for ambulance list page */
	@Test
	@WithAnonymousUser
	void testAmbulanceListWithAnonymous() throws Exception {
		mvc.perform(get("/ambulancelist")).andExpect(status().isOk());
	}

	/* Testing for hospital list page */
	@Test
	@WithAnonymousUser
	void testHospitalListWithAnonymous() throws Exception {
		mvc.perform(get("/hospitallist")).andExpect(status().isOk());
	}

	/* Testing for hospital home page */
	@Test
	@WithAnonymousUser
	void testHospitalWithAnonymous() throws Exception {
		mvc.perform(get("/hospital")).andExpect(status().isOk());
	}

	@MockBean
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@MockBean
	private HospitalRepository hospitalRepository;

	@Autowired
	private HospitalServiceImpl hospitalServiceImpl;

	/* Testing for finding all doctor comment */
	@Test
	public void getComments() {
		when(doctorRepository.findAll())
				.thenReturn(Stream.of(new Doctor("heena", "ameena", "sick")).collect(Collectors.toList()));
		assertEquals(1, doctorServiceImpl.getAllDoctorComments().size());
	}

	/* Testing for saving all doctors comment */
	@Test
	public void savedoctorsComments() {
		Doctor d = new Doctor("heena", "ameena", "sick");
		when(doctorRepository.save(d)).thenReturn(d);
		assertEquals(d, doctorServiceImpl.createDoctor(d));

	}

	/* Test cases for DoctorUserServiceImpl */

	@Autowired
	DoctorUserServiceImpl doctorUserServiceImpl;

	@MockBean
	DoctorUserRepository doctorUserRepository;

	/* Testing for saving doctors */
	@Test
	public void savedoctorUser() {
		DoctorUser d1 = new DoctorUser("heena", "123", "heena@gmail.com", "cardiology", "hina", "abc", "abc");
		when(doctorUserRepository.save(d1)).thenReturn(d1);
		assertEquals(d1, doctorUserServiceImpl.createDoctorUser(d1));

	}

	/* test cases for patientDetaiilsServiceImpl */

	@Autowired
	PatientDetailsServiceImpl patientDetailsServiceImpl;
	@MockBean
	private PatientDetailsRepository patientDetailsRepository;

	/* Testing for creating patients */
/*	@Test
	public void createPatient() {

		PatientDetails p1 = new PatientDetails("priya", 23, "aaa", "o positive", "fever", "null", 95, 89, 88);
		when(patientDetailsRepository.save(p1)).thenReturn(p1);
		assertEquals(p1, patientDetailsServiceImpl.createPatientDetails(p1));

	}

	 Testing for finding all patient details 
	@Test
	public void AllPatientDeatils() {
		when(patientDetailsRepository.findAll())
				.thenReturn(Stream.of(new PatientDetails("priya", 23, "aaa", "o positive", "fever", "null", 95, 89, 88))
						.collect(Collectors.toList()));

	}*/

	/* Test cases for userServiceImpl */

	@Autowired
	UserServiceImpl userServiceImpl;
	@MockBean
	UserRepository userRepository;

	/* Testing for creating nurse */
	/*@Test
	public void createUser() {
		User u = new User("heena", "123", "heena@gmail.com", "hina", "abc", "abc");
		when(userRepository.save(u)).thenReturn(u);
		assertEquals(u, userServiceImpl.createUser(u));
	}
*/
	/* Testing for creating hospital */
	@Test
	public void createHospital() {

		Hospital p1 = new Hospital("jayadev", "jayadeva", "9876543210");
		when(hospitalRepository.save(p1)).thenReturn(p1);
		assertEquals(p1, hospitalServiceImpl.createHospital(p1));

	}
}
