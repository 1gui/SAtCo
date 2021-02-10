package control.main;

import model.dao.company.CompanyDAO;
import model.entity.company.Company;

public class Main {

	public static void main(String[] args) {
		
		CompanyDAO companyDAO = new CompanyDAOIMPL();
		//PositionDAO positionDAO = new positionDAOIMPL();
		//ProfileDAO profileDAO = new profileDAOIMPL();
		//UserDAO userDAO = new userDAOIMPL();
		
		String name = "AmbevTech";
		String cnpj = "192.324.124-59";
		String email = "ambevtech@gmail.com";
		String address = "rua gasparzinho";
		int phone = 47932019392;
		
		Company company = new Company();
		
		company.setName(name);
		company.setCnpj(cnpj);
		company.setEmail(email);
		company.setAddress(address);
		company.setPhone(phone);
		
		CompanyDAO.insertCompany(company);
	}
}
