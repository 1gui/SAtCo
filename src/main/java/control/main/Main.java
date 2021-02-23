package control.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
import model.entity.frequency.Frequency;
import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
import model.enumeration.frequency.FrequencyStatus;
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
						menuP = MenuPrimary.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						menuP = MenuPrimary.INVALID;
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
							int numberStudent = sc.nextInt();
							sc.next();
							Student student = studentDAO.recoverStudent(students.get(numberStudent));

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
							
							student.setName(name);
							student.setCpf(cpf);
							student.setEmail(email);
							studentDAO.updateStudent(student);
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
							studentDAO.removeStudent(student);
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
				while (menuS != MenuSecondary.EXIT) {
					System.out.println("Turma - Opções\n[0-Cadastrar]\n[1-Editar]\n[2-Apagar]\n[3-Sair]");
					try {
						menuS = MenuSecondary.values()[Integer.parseInt(sc.next())];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						menuP = MenuPrimary.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						menuP = MenuPrimary.INVALID;
					}

					switch (menuS) {

					case REGISTER:

						try {
							System.out.println("\n\nDigite o nome da turma:");
							String name = sc.next();
							courseDAO.insertCourse(new Course(name));
							System.out.println("Turma inserida.");

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
							System.out.println("Buscando turmas...");
							List<Course> courses = courseDAO.listCourse();
							for (int i = 0; i < courses.size(); i++) {
								System.out.println(i + " " + courses.get(i).getName());
							}
							System.out.println("Selecione uma turma para editar");
							int numberCourse = sc.nextInt();
							sc.next();
							Course course = courseDAO.recoverCourse(courses.get(numberCourse));
							System.out.println(
									"\n\n O nome atual da turma é:" + course.getName() + ". Digite o nome da turma:");
							String name = sc.nextLine();
							course.setName(name);
							courseDAO.updateCourse(course);
							System.out.println("Turma atualizado.");

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
							System.out.println("Buscando turmas...");
							List<Course> courses = courseDAO.listCourse();
							for (int i = 0; i < courses.size(); i++) {
								System.out.println(i + " " + courses.get(i).getName());
							}
							System.out.println("Selecione uma turma para remover");
							int numberCourse = sc.nextInt();
							sc.next();
							Course course = courseDAO.recoverCourse(courses.get(numberCourse));
							courseDAO.removeCourse(course);
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

			case COMPANY:
				while (menuS != MenuSecondary.EXIT) {
					System.out.println("Empresa - Opções\n[0-Cadastrar]\n[1-Editar]\n[2-Apagar]\n[3-Sair]");
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
							System.out.println("\n\nDigite o nome da empresa:");
							String name = sc.next();
							System.out.println("Digite o CNPJ da empresa:");
							String cnpj = sc.next();
							System.out.println("Digite o email da empresa:");
							String email = sc.next();
							System.out.println("Digite o endereço da empresa:");
							String address = sc.next();
							System.out.println("Digite o telefone da empresa:");
							String phone = sc.next();
							System.out.println("Buscando Turmas..");
							List<Company> companies = companyDAO.listCompany();
							for (int i = 0; i < companies.size(); i++) {
								System.out.println(i + " " + companies.get(i).getName());
							}
							companyDAO.insertCompany(new Company(name, cnpj, email, address, phone));
							System.out.println("Empresa inserido.");

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
							System.out.println("Buscando Empresas...");
							List<Company> companies = companyDAO.listCompany();
							for (int i = 0; i < companies.size(); i++) {
								System.out.println(i + " " + companies.get(i).getName());
							}
							System.out.println("Selecione uma empresa para editar");
							int numeroEmpresa = sc.nextInt();
							sc.next();
							Company company = companyDAO.recoverCompany(companies.get(numeroEmpresa));

							System.out.println("\n\n O nome atual da empresa é:" + company.getName()
									+ ". Digite o nome da empresa:");
							String name = sc.next();
							System.out.println(
									"O CNPJ atual da empresa é:" + company.getCnpj() + ". Digite o CNPJ da empresa:");
							String cnpj = sc.next();
							System.out.println("O e-mail atual da empresa é:" + company.getEmail()
									+ ". Digite o e-mail da empresa:");
							String email = sc.next();
							System.out.println("O endereço atual da empresa é:" + company.getAddress()
									+ ". Digite o endereço da empresa:");
							String address = sc.next();
							System.out.println("O telefone atual da empresa é:" + company.getPhone()
									+ ". Digite o telefone da empresa:");
							String phone = sc.next();

							company.setName(name);
							company.setCnpj(cnpj);
							company.setEmail(email);
							company.setAddress(address);
							company.setPhone(phone);
							companyDAO.updateCompany(company);
							System.out.println("Empresa atualizada.");

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
							System.out.println("Buscando empresas...");
							List<Company> companies = companyDAO.listCompany();
							for (int i = 0; i < companies.size(); i++) {
								System.out.println(i + " " + companies.get(i).getName());
							}
							System.out.println("Selecione uma empresa para remover");
							int numberCompany = sc.nextInt();
							sc.next();
							Company company = companyDAO.recoverCompany(companies.get(numberCompany));
							companyDAO.removeCompany(company);
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

			case SUBJECT:

				while (menuS != MenuSecondary.EXIT) {
					System.out.println("Materia - Opções\n[0-Cadastrar]\n[1-Editar]\n[2-Apagar]\n[3-Sair]");
					try {
						menuS = MenuSecondary.values()[Integer.parseInt(sc.next())];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						menuP = MenuPrimary.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						menuP = MenuPrimary.INVALID;
					}

					switch (menuS) {

					case REGISTER:

						try {
							System.out.println("\n\nDigite o nome da materia:");
							String name = sc.next();
							System.out.println("Buscando professores...");
							List<Teacher> teachers = teacherDAO.listTeacher();
							for (int i = 0; i < teachers.size(); i++) {
								System.out.println(i + " " + teachers.get(i).getName());
							}
							System.out.println("Digite o numero da turma do aluno:");
							int numberTeacher = sc.nextInt();
							sc.next();
							Teacher teacher = teachers.get(numberTeacher);
							subjectDAO.insertSubject(new Subject(name, teacher));
							System.out.println("Materia inserida.");

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
							System.out.println("Buscando materias...");
							List<Subject> subjects = subjectDAO.listSubject();
							for (int i = 0; i < subjects.size(); i++) {
								System.out.println(i + " " + subjects.get(i).getName());
							}
							System.out.println("Selecione uma materia para editar");
							int numberSubject = sc.nextInt();
							sc.next();
							Subject subject = subjectDAO.recoverSubject(subjects.get(numberSubject));

							System.out.println("\n\n O nome atual da materia é:" + subject.getName()
									+ ". Digite o nome do aluno:");
							String name = sc.next();
							System.out.println("O professor atual da materia é" + subject.getTeacher().getName()
									+ ". Buscando professores...");
							List<Teacher> teachers = teacherDAO.listTeacher();
							for (int i = 0; i < teachers.size(); i++) {
								System.out.println(i + " " + teachers.get(i).getName());
							}
							System.out.println("Digite o numero do professor da materia:");
							int numberTeacher = sc.nextInt();
							sc.next();
							Teacher teacher = teachers.get(numberTeacher);
							subject.setName(name);
							subject.setTeacher(teacher);
							subjectDAO.updateSubject(subject);
							System.out.println("Materia atualizada.");

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
							System.out.println("Buscando materias...");
							List<Subject> subjects = subjectDAO.listSubject();
							for (int i = 0; i < subjects.size(); i++) {
								System.out.println(i + " " + subjects.get(i).getName());
							}
							System.out.println("Selecione uma materia para remover");
							int numberSubject = sc.nextInt();
							sc.next();
							Subject subject = subjectDAO.recoverSubject(subjects.get(numberSubject));
							subjectDAO.removeSubject(subject);
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

			case TEACHER:

				while (menuS != MenuSecondary.EXIT) {
					System.out.println("Professor - Opções\n[0-Cadastrar]\n[1-Editar]\n[2-Apagar]\n[3-Sair]");
					try {
						menuS = MenuSecondary.values()[Integer.parseInt(sc.next())];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						menuP = MenuPrimary.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						menuP = MenuPrimary.INVALID;
					}

					switch (menuS) {

					case REGISTER:
						try {
							System.out.println("\n\nInsira o nome do professor:");
							String name = sc.next();
							System.out.println("Insira o CPF do professor:");
							String cpf = sc.next();
							System.out.println("Insira o E-mail do professor:");
							String email = sc.next();
							System.out.println("Buscando materias...");
							List<Subject> subjects = subjectDAO.listSubject();
							for (int i = 0; i < subjects.size(); i++) {
								System.out.println(i + " " + subjects.get(i).getName());
							}
							System.out.println("Selecione uma materia para inserir:");
							int numberSubject = sc.nextInt();
							sc.next();
							Subject subject = subjectDAO.recoverSubject(subjects.get(numberSubject));
							System.out.println("Buscando turmas:");
							List<Course> courses = courseDAO.listCourse();
							for (int i = 0; i < courses.size(); i++) {
								System.out.println(i + " " + courses.get(i).getName());
							}
							System.out.println("Selecione uma turma para inserir:");
							int numberCourse = sc.nextInt();
							sc.next();
							Course course = courseDAO.recoverCourse(courses.get(numberCourse));
							Teacher teacher = new Teacher(name, cpf, email);
							teacher.addCourse(course);
							teacher.addSubject(subject);
							teacherDAO.insertTeacher(teacher);
							System.out.println("Professor adicionado...");
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
							System.out.println("Procurando professores...");
							List<Teacher> teachers = teacherDAO.listTeacher();
							for (int i = 0; i < teachers.size(); i++) {
								System.out.println(i + " " + teachers.get(i).getName());
							}
							System.out.println("Digite o numero do professor para editar:");
							int numberTeacher = sc.nextInt();
							sc.next();
							Teacher teacher = teachers.get(numberTeacher);
							System.out.println(
									"\n\nO nome atual do professor é: " + teacher.getName() + ". Digite o nome:");
							String name = sc.nextLine();
							System.out.println("O CPF atual do professor é: " + teacher.getCpf() + ". Digite o CPF:");
							String cpf = sc.next();
							System.out.println(
									"O E-mail atual do professor é: " + teacher.getEmail() + ". Digite o E-mail:");
							String email = sc.next();
							System.out.println("Mudar a matéria do professor?\n[0-Sim]\n[1-Não]");
							int changeSubject = sc.nextInt();
							if (changeSubject == 0) {
								Subject oldSubject = teacher.getSubjects().get(1);
								List<Subject> subjects = subjectDAO.listSubject();
								for (int i = 0; i < subjects.size(); i++) {
									System.out.println(i + "- " + subjects.get(i).getName());
								}
								System.out.println("Selecione uma materia:");
								int numberSubject = sc.nextInt();
								Subject newSubject = subjects.get(numberSubject);
								teacher.removeSubject(oldSubject);
								teacher.addSubject(newSubject);
							}
							System.out.println("Mudar a turma do professor?\n[0-Sim]\n[1-Não]");
							int changeCourse = sc.nextInt();
							if (changeCourse == 0) {
								Course oldCourse = teacher.getCourses().get(1);
								List<Course> courses = courseDAO.listCourse();
								for (int i = 0; i < courses.size(); i++) {
									System.out.println(i + "- " + courses.get(i).getName());
								}
								int numberCourse = sc.nextInt();
								Course newCourse = courses.get(numberCourse);
								teacher.removeCourse(oldCourse);
								teacher.addCourse(newCourse);
							}
							teacher.setCpf(cpf);
							teacher.setEmail(email);
							teacher.setName(name);

							teacherDAO.updateTeacher(teacher);

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
							List<Teacher> teachers = teacherDAO.listTeacher();
							for (int i = 0; i < teachers.size(); i++) {
								System.out.println(i + " " + teachers.get(i).getName());
							}
							System.out.println("Digite o numero do professor para remover:");
							int numberTeacher = sc.nextInt();
							sc.next();
							Teacher teacher = teachers.get(numberTeacher);
							teacherDAO.removeTeacher(teacher);
							System.out.println("Professor removido...");

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

			case ROLLCALL:
				try {
					System.out.println("Buscando alunos...");
					System.out.println("\n\n");
					List<Student> students = studentDAO.listStudent();
					for (int i = 0; i < students.size(); i++) {
						Student student = students.get(i);
						System.out.println("ESTUDANTE: " + student.getName()
								+ ": \n[0-FALTOU]\n[1-PRESENTE]\n[2-FALTA JUSTIFICADA]");
						int call = sc.nextInt();
						switch (call) {
						case 0:
							Frequency frequency = new Frequency(FrequencyStatus.ABSENCE, student);
							
							frequencyDAO.insertFrequency(frequency);
							break;
						case 1:
							Frequency frequencyP = new Frequency(FrequencyStatus.PRESENCE, student);
							
							frequencyDAO.insertFrequency(frequencyP);
							break;
						case 2:
							Frequency frequencyJ = new Frequency(FrequencyStatus.JUSFIED_ABSENCE, student);
							System.out.println("Insira a justificativa:");
							String justified = sc.nextLine();
							frequencyJ.setJusfied(justified);
							frequencyDAO.insertFrequency(frequencyJ);
							break;

						}
					}

				} catch (InputMismatchException ime) {
					System.out.println("Algo errado foi digitado!");
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					System.out.println("Um numero fora de limites foi digitado.");
				} catch (NullPointerException npe) {
					System.out.println("Algo estava vazio no sistema e não pode ser encontrado.");
				}
				break;

			case REPORT:

				try {
					System.out.println("Buscando alunos..");
					List<Student> students = studentDAO.listStudent();
					for (int i = 0; i < students.size(); i++) {
						System.out.println("| " + students.get(i).getName());
						for (int j = 0; j < students.get(i).getFrequencys().size(); j++) {
							System.out.print("|" + students.get(i).getFrequencys().get(j).getDate() + ": "
									+ students.get(i).getFrequencys().get(j).getStatus());
							if (students.get(i).getFrequencys().get(j).getJusfied() != null) {
								System.out.println(students.get(i).getFrequencys().get(j).getJusfied());
							}
						}
						System.out.println("\n|_");
					}

				} catch (InputMismatchException ime) {
					System.out.println("Algo errado foi digitado!");
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					System.out.println("Um numero fora de limites foi digitado.");
				} catch (NullPointerException npe) {
					System.out.println("Algo estava vazio no sistema e não pode ser encontrado.");
				}
				break;

			default:
				break;
			}
			menuP = MenuPrimary.INVALID;
			menuS = MenuSecondary.INVALID;
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