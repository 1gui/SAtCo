package control.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import model.dao.company.CompanyDAO;
import model.dao.company.CompanyDAOImpl;
import model.dao.course.CourseDAO;
import model.dao.course.CourseDAOImpl;
import model.dao.frequency.FrequencyDAO;
import model.dao.frequency.FrequencyDAOImpl;
import model.dao.student.StudentDAO;
import model.dao.student.StudentDAOImpl;
import model.dao.subject.SubjectDAO;
import model.dao.subject.SubjectDAOImpl;
import model.dao.teacher.TeacherDAO;
import model.dao.teacher.TeacherDAOImpl;
import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.student.Student;
import model.enumeration.primary.MenuPrimary;
import model.enumeration.secondary.MenuSecondary;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MenuPrimary menuP = MenuPrimary.INVALID;
		MenuSecondary menuS = MenuSecondary.INVALID;

		CompanyDAO companyDAO = new CompanyDAOImpl();
		CourseDAO courseDAO = new CourseDAOImpl();
		FrequencyDAO frequencyDAO = new FrequencyDAOImpl();
		StudentDAO studentDAO = new StudentDAOImpl();
		SubjectDAO subjectDAO = new SubjectDAOImpl();
		TeacherDAO teacherDAO = new TeacherDAOImpl();

		System.out.println("BEM VINDO AO SISTEMA SAtCo");
		System.out.println(
				"Digite um numero para selecionar uma opção" + "\n[0-Aluno]\n[1-Classe]\n[2-Empresa]\n[3-Matéria]"
						+ "\n[4-Professor]\n[5-Chamada]\n[6-Relatório]\n[7-Sair] ");

		while (menuP == MenuPrimary.INVALID) {
			try {
				menuP = MenuPrimary.values()[Integer.parseInt(sc.next())];
			} catch (InputMismatchException ime) {
				System.out.println("Digite apenas numeros inteiros nos menus.");
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Digite apenas os numeros do display.");
			}
		}

		while (menuP != MenuPrimary.EXIT) {

			switch (menuP) {

			case STUDENT:
				while (menuS != MenuSecondary.EXIT) {
					System.out.println("Aluno - Opções\n[0-Cadastrar]\n[1-Editar]\n[2-Apagar]\n[3-Sair]");
					try {
						menuS = MenuSecondary.values()[Integer.parseInt(sc.next())];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
					}

					switch (menuS) {

					case REGISTER:

						try {
							System.out.println("\n\nDigite o nome do aluno:");
							String name = sc.next();
							System.out.println("Digite o CPF do aluno:");
							String cpf = sc.next();
							System.out.println("Digite o email do aluno:");
							String email = sc.next();
							System.out.println("Buscando Turmas..");
							List<Course> courses = courseDAO.listCourse();
							for (int i = 0; i < courses.size(); i++) {
								System.out.println(i + " " + courses.get(i).getName());
							}
							System.out.println("Digite o numero da turma do aluno:");
							int courseNumber = sc.nextInt();
							sc.next();
							Course course = courses.get(courseNumber);
							System.out.println("Buscando Empresas...");
							List<Company> companies = companyDAO.listCompany();
							for (int i = 0; i < companies.size(); i++) {
								System.out.println(i + " " + companies.get(i).getName());
							}
							System.out.println("Digite o numero da compania a ser vinculada ao aluno:");
							int companyNumber = sc.nextInt();
							sc.next();
							Company company = companies.get(companyNumber);
							studentDAO.insertStudent(new Student(name, cpf, email, course, company));
							System.out.println("Aluno inserido.");

						} catch (InputMismatchException ime) {
							System.out.println("Algo errado foi digitado!");
						} catch (ArrayIndexOutOfBoundsException aiobe) {
							System.out.println("Um numero fora de limites foi digitado.");
						} catch (NullPointerException npe) {
							System.out.println("Algo estava vazio no sistema e não pode ser encontrado.");
						}

						break;

					case EDIT:
						try {
							System.out.println("Buscando alunos...");
							List<Student> students = studentDAO.listStudent();
							for (int i = 0; i < students.size(); i++) {
								System.out.println(i + " " + students.get(i).getName());
							}
							System.out.println("Selecione um aluno para editar");
							int numeroAluno = sc.nextInt();
							sc.next();
							Student student = studentDAO.recoverStudent(students.get(numeroAluno));

							System.out.println(
									"\n\n O nome atual do aluno é:" + student.getName() + ". Digite o nome do aluno:");
							String name = sc.next();
							System.out
									.println("O CPF atual do aluno é:" + student.getCpf() + ". Digite o CPF do aluno:");
							String cpf = sc.next();
							System.out.println(
									"O e-mail atual do aluno é:" + student.getEmail() + ". Digite o e-mail do aluno:");
							String email = sc.next();
							System.out.println(
									"A turma atual do aluno é" + student.getCourse().getName() + ". Buscando Turmas..");
							List<Course> courses = courseDAO.listCourse();
							for (int i = 0; i < courses.size(); i++) {
								System.out.println(i + " " + courses.get(i).getName());
							}
							System.out.println("Digite o numero da turma do aluno:");
							int courseNumber = sc.nextInt();
							sc.next();
							Course course = courses.get(courseNumber);
							System.out.println("A empresa atual do aluno é:" + student.getCompany().getName()
									+ ". Buscando Empresas...");
							List<Company> companies = companyDAO.listCompany();
							for (int i = 0; i < companies.size(); i++) {
								System.out.println(i + " " + companies.get(i).getName());
							}
							System.out.println("Digite o numero da compania a ser vinculada ao aluno:");
							int companyNumber = sc.nextInt();
							sc.next();
							Company company = companies.get(companyNumber);
							studentDAO.updateStudent(new Student(student.getId(), name, cpf, email, course, company));
							System.out.println("Aluno atualizado.");

						} catch (InputMismatchException ime) {
							System.out.println("Algo errado foi digitado!");
						} catch (ArrayIndexOutOfBoundsException aiobe) {
							System.out.println("Um numero fora de limites foi digitado.");
						} catch (NullPointerException npe) {
							System.out.println("Algo estava vazio no sistema e não pode ser encontrado.");
						}

						break;

					case DELETE:
						try {
						System.out.println("Buscando alunos...");
						List<Student> students = studentDAO.listStudent();
						for (int i = 0; i < students.size(); i++) {
							System.out.println(i + " " + students.get(i).getName());
						}
						System.out.println("Selecione um aluno para remover");
						int numeroAluno = sc.nextInt();
						sc.next();
						Student student = studentDAO.recoverStudent(students.get(numeroAluno));
						studentDAO.recoverStudent(student);
						} catch (InputMismatchException ime) {
							System.out.println("Algo errado foi digitado!");
						} catch (ArrayIndexOutOfBoundsException aiobe) {
							System.out.println("Um numero fora de limites foi digitado.");
						} catch (NullPointerException npe) {
							System.out.println("Algo estava vazio no sistema e não pode ser encontrado.");
						}
						break;

					}
				}
				break;

			case COURSE:
				break;

			case COMPANY:
				break;

			case SUBJECT:
				break;

			case TEACHER:
				break;

			case ROLLCALL:
				break;

			case REPORT:
				break;

			case EXIT:
				;

			default:
				break;
			}
			System.out.println("Voltando ao menu principal");
			System.out.println("BEM VINDO AO SISTEMA SAtCo");
			System.out.println(
					"Digite um numero para selecionar uma opção" + "\n[0-Aluno]\n[1-Classe]\n[2-Empresa]\n[3-Matéria]"
							+ "\n[4-Professor]\n[5-Chamada]\n[6-Relatório]\n[7-Sair] ");
			try {
				menuP = MenuPrimary.values()[Integer.parseInt(sc.next())];
			} catch (InputMismatchException ime) {
				System.out.println("Digite apenas numeros inteiros nos menus.");
				menuP = MenuPrimary.INVALID;
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Digite apenas os numeros do display.");
				menuP = MenuPrimary.INVALID;
			}

		}
		System.out.println("Execucao terminada.");
	}
}
