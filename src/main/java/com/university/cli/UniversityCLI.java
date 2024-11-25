package com.university.cli;

import com.university.cli.Entity;
import com.university.cli.CLI;
import com.university.cli.e.DuplicateEntityException;
import com.university.cli.e.EntityNotFoundException;
import com.university.cli.e.InvalidInputException;

import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.mainobjects.Student;
import com.university.mainobjects.Course;
import com.university.evaluation.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UniversityCLI implements CLI {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        System.out.println("Welcome to SIU Guarani");
        boolean running = true;

        while (running) {
            System.out.println("\nSelect an entity to manage:");
            for (int i = 0; i < crudInterfaces.length; i++) {
                System.out.println((i + 1) + ". " + crudInterfaces[i].getIdentifier());
            }
            System.out.println((crudInterfaces.length + 1) + ". Exit");

            // Bucle de entrada controlada
            int entityChoice = -1;
            while (entityChoice < 1 || entityChoice > crudInterfaces.length + 1) {
                System.out.print("Choose a valid number between 1 and " + (crudInterfaces.length + 1) + ": ");
                try {
                    entityChoice = scanner.nextInt();
                    if (entityChoice < 1 || entityChoice > crudInterfaces.length + 1) {
                        System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input is not a valid number. Please enter a number between 1 and " + (crudInterfaces.length + 1) + ".");
                    scanner.nextLine(); // Limpiar el buffer
                }
            }

            switch (entityChoice) {
                case 1:
                case 2:
                case 3: {
                    CRUDRepository<?> selectedRepository = crudInterfaces[entityChoice - 1];
                    handleCrudOperations(selectedRepository);
                    break;
                }
                case 4: {
                    running = false;
                    System.out.println("Exiting... ");
                    break;
                }
            }
        }
    }

    private int getValidIntegerInput(int min, int max) {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter a number between " + min + " and " + max + ": ");
                input = scanner.nextInt();
                scanner.nextLine();

                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    System.out.println("Error: Number must be between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error: Input is not a valid number. Please enter a number between " + min + " and " + max + ".");
            }
        }
        return input;
    }


    private <T extends Entity> void handleCrudOperations(CRUDRepository<T> repository) {
        boolean manageEntity = true;
        while (manageEntity) {
            System.out.println("\nManaging: " + repository.getIdentifier()); //barrita n es saltear un renglon
            System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n5. Go back");

            try {
                int operation = getValidIntegerInput(1, 5);

                switch (operation) {
                    case 1:
                        createEntity(repository);
                        break;
                    case 2:
                        readEntity(repository);
                        break;
                    case 3:
                        updateEntity(repository);
                        break;
                    case 4:
                        deleteEntity(repository);
                        break;
                    case 5:
                        manageEntity = false;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }



    private <T extends Entity> void createEntity(CRUDRepository<T> repository) {
        System.out.println("\nCreating new " + repository.getIdentifier() + "...");

        try {
            System.out.print("Enter ID for the " + repository.getIdentifier() + ": ");
            int id = getValidIntegerInput(1, Integer.MAX_VALUE);

            T entity = getEntityDataFromUser(repository.getEntityClass());
            entity.setId(id);
            repository.create(entity);
            System.out.println(repository.getIdentifier() + " with ID " + id + " created successfully.");

        } catch (DuplicateEntityException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }



    private <T extends Entity> void readEntity(CRUDRepository<T> repository) {
        System.out.print("Enter the ID of the " + repository.getIdentifier() + " to read: ");

        try {
            int id = getValidIntegerInput(1, Integer.MAX_VALUE);
            T entity = repository.read(id);
            System.out.println("Details of " + repository.getIdentifier() + ": " + entity);

        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }


    private <T extends Entity> void updateEntity(CRUDRepository<T> repository) {
        System.out.print("Enter the ID of the " + repository.getIdentifier() + " to update: ");

        try {
            int id = getValidIntegerInput(1, Integer.MAX_VALUE);
            T entity = repository.read(id);

            System.out.println("Enter new data for the " + repository.getIdentifier() + ":");
            T updatedEntity = getEntityDataFromUser(repository.getEntityClass());
            updatedEntity.setId(id);
            repository.update(id, updatedEntity);

            System.out.println(repository.getIdentifier() + " with ID " + id + " updated successfully.");

        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }


    private <T extends Entity> void deleteEntity(CRUDRepository<T> repository) {
        System.out.print("Enter the ID of the " + repository.getIdentifier() + " to delete: ");

        try {
            int id = getValidIntegerInput(1, Integer.MAX_VALUE);
            repository.delete(id);
            System.out.println(repository.getIdentifier() + " with ID " + id + " deleted successfully.");

        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }



    private <T extends Entity> T getEntityDataFromUser(Class<T> entityClass) {
        while (true) {
            try {
                if (entityClass == Student.class) {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        throw new InvalidInputException("Student name cannot be empty.");
                    }

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine().trim();
                    if (email.isEmpty()) {
                        throw new InvalidInputException("Student email cannot be empty.");
                    }

                    return entityClass.cast(new Student(name, email));
                } else if (entityClass == Course.class) {
                    System.out.print("Enter course subject: ");
                    String subject = scanner.nextLine().trim();
                    if (subject.isEmpty()) {
                        throw new InvalidInputException("Course subject cannot be empty.");
                    }

                    Course course = new Course(subject);

                    return entityClass.cast(course);
                } else if (entityClass == Evaluation.class) {
                    System.out.print("Enter student name for evaluation: ");
                    String studentName = scanner.nextLine().trim();
                    if (studentName.isEmpty()) {
                        throw new InvalidInputException("Student name cannot be empty.");
                    }

                    System.out.print("Enter evaluation subject: ");
                    String subject = scanner.nextLine().trim();
                    if (subject.isEmpty()) {
                        throw new InvalidInputException("Subject cannot be empty.");
                    }

                    System.out.print("Enter evaluation name: ");
                    String evalName = scanner.nextLine().trim();
                    if (evalName.isEmpty()) {
                        throw new InvalidInputException("Evaluation name cannot be empty.");
                    }

                    System.out.print("Enter evaluation grade: ");
                    String evalgrade = scanner.nextLine().trim();
                    Double evalgrade1 = Double.parseDouble(evalgrade);
                    if (evalName.isEmpty()) {
                        throw new InvalidInputException("Evaluation grade cannot be empty.");
                    }

                    // Elegir el tipo de evaluación
                    System.out.println("Choose evaluation type:\n1. WrittenExam\n2. OralExam\n3. PracticalWork\n4. FinalPracticalWork");
                    int evalTypeChoice = getValidIntegerInput(1, 4);

                    switch (evalTypeChoice) {
                        case 1 -> {
                            return entityClass.cast(new WrittenExam(studentName, subject, "WrittenExam", evalName, evalgrade1));
                        }
                        case 2 -> {
                            return entityClass.cast(new OralExam(studentName, subject, "OralExam", evalName, evalgrade1));
                        }
                        case 3 -> {
                            return entityClass.cast(new PracticalWork(studentName, subject, "PracticalWork", evalName, evalgrade1));
                        }
                        case 4 -> {
                            return entityClass.cast(new FinalPracticalWork(studentName, subject, "FinalPracticalWork", evalName, evalgrade1));
                        }
                        default -> throw new InvalidInputException("Invalid evaluation type.");
                    }
                }
                throw new InvalidInputException("Unsupported entity type.");
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

}