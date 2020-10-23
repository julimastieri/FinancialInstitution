package main.java.com.solvd;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import main.java.com.solvd.connectionPool.*;
import main.java.com.solvd.connectionPool.ThreadTask;
import main.java.com.solvd.credits.*;
import main.java.com.solvd.doublyLinkedList.DoublyLinkedList;
import main.java.com.solvd.enums.ScoreLevel;
import main.java.com.solvd.people.*;
import main.java.com.solvd.financialInstitutions.*;
import main.java.com.solvd.interfaces.ListToDouble;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
		PropertyConfigurator.configure("log4j.properties");

		// getClassInstancesExample();
		// linkedListExample();
		// fileExercise();
		connectionPoolExercise();
		// completableFutureExercise();

	}

	public static void connectionPoolExercise() throws InterruptedException, ExecutionException {
		ConnectionPool cp = new ConnectionPool();
		ExecutorService executor =Executors.newFixedThreadPool(10);
		
		// Threads
		ThreadTask thread1 = new ThreadTask(1, cp);
		ThreadTask thread2 = new ThreadTask(2, cp);
		ThreadTask thread3 = new ThreadTask(3, cp);
		RunnableTask runnable1 = new RunnableTask(4, cp);
		RunnableTask runnable2 = new RunnableTask(5, cp);
		RunnableTask runnable3 = new RunnableTask(6, cp);
		
		executor.execute(thread1);
		executor.execute(thread2);
		executor.execute(thread3);
		executor.execute(runnable1);
		executor.execute(runnable2);
		executor.execute(runnable3);
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			logger.error(e);
		}

	}

	public static void completableFutureExercise() throws InterruptedException, ExecutionException {
		ConnectionPool cp = new ConnectionPool();

		// Threads
		ThreadTask thread1 = new ThreadTask(1, cp);
		ThreadTask thread2 = new ThreadTask(2, cp);
		ThreadTask thread3 = new ThreadTask(3, cp);
		RunnableTask runnable1 = new RunnableTask(4, cp);
		RunnableTask runnable2 = new RunnableTask(5, cp);
		RunnableTask runnable3 = new RunnableTask(6, cp);

		CompletableFuture<Void> future = new CompletableFuture<Void>();
		CompletableFuture.runAsync(runnable1);
		CompletableFuture.runAsync(runnable2);
		CompletableFuture.runAsync(runnable3);
		CompletableFuture.runAsync(thread1);
		CompletableFuture.runAsync(thread2);
		CompletableFuture.runAsync(thread3);
		
		future.get();
	}

	public static void fileExercise() throws IOException {
		File file = FileUtils.getFile(System.getProperty("user.dir") + "/FileTextToRead.txt");
		String fileText = FileUtils.readFileToString(file, "UTF-8");

		String[] words = StringUtils.split(fileText);
		Set<String> uniqueWords = new HashSet<String>(Arrays.asList(words));
		StringBuilder dataToWrite = new StringBuilder();
		uniqueWords.forEach(word -> dataToWrite.append(word + " " + StringUtils.countMatches(fileText, word) + "\n"));

		file = FileUtils.getFile(System.getProperty("user.dir") + "/CountWords.txt");
		FileUtils.writeStringToFile(file, dataToWrite.toString(), "UTF-8");
	}

	public static void linkedListExample() {
		// DoublyLinkedList
		logger.info("---DoublyLinkedList---");
		DoublyLinkedList<String> DLL = new DoublyLinkedList<String>();
		DLL.add("Financial");
		DLL.add("Institution");
		DLL.add("Program");

		DLL.remove("Institution");

		logger.info("List size: " + DLL.size());

		logger.info("Contains 'Institution': " + DLL.contains("Institution"));

		DoublyLinkedList<String> DLL2 = new DoublyLinkedList<String>();
		DLL2.add("Financial");
		DLL2.add("Program");
		logger.info("DLL contains DLL2: " + DLL.containsAll(DLL2));
		DLL2.add("Bank");
		logger.info("DLL contains DLL2: " + DLL.containsAll(DLL2));
	}

	public static void getClassInstancesExample() {
		// Banks
		CommercialBank creditOneBank = new CommercialBank(123456789, "Credit One Bank", "Evergreen 123", 9);
		InternetBank eBank = new InternetBank(234567819, "eBank", "www.ebank.com");

		// Clients
		Client client = new Client("John", "Greenwood", 23896777, "Male", 33, "British", "Finance Analyst", 1250,
				123456789);
		Client client2 = new Client("Elsa", "Polin", 89123456, "Female", 33, "British", "Doctor", 500, 887612003);
		Client client3 = new Client("Gil", "Vergen", 23451768, "Female", 33, "British", "Engineer", 1800, 442381922);

		// CreditAnalysts
		CreditAnalyst credAnalistOneBank = new CreditAnalyst("Ane", "Whitaker", 19345147, "Female", 40, "Irish",
				"Credit", creditOneBank, 750);
		CreditAnalyst credAnalistEBank = new CreditAnalyst("James", "Stewart", 345134598, "Male", 60, "American",
				"Credit", eBank, 850);

		// Credit Managers
		CreditManager credManagerOneBank = new CreditManager("Coby", "Bennett", 15789122, "Male", 51, "British",
				"Credit", creditOneBank, 1500, ScoreLevel.HIGH);
		CreditManager credManagerEBank = new CreditManager("John", "Greenwood", 23896777, "Male", 33, "British",
				"Finance", eBank, 1250, ScoreLevel.LOW);

		logger.info("---CreditOneBank employees---");
		creditOneBank.getEmployees().forEach(emp -> logger.info("-" + emp));
		logger.info("---eBank employees---");
		eBank.getEmployees().forEach(emp -> logger.info("-" + emp));

		logger.info("---Using the Person equals---");
		if (credManagerEBank.equals(client)) {
			logger.info("This client is the same person as this employee");
		} else
			logger.info("This client isn't the same person as this Credit Manager");

		// Clients requesting credits
		credAnalistOneBank.generateCarCreditSolicitation(448547650, 2000, 0.1f, 12, client, "AB289LM", "Ford",
				"EcoSport", 2020);
		credAnalistEBank.generateBusinessCreditSolicitation(558547234, 5000, 0.13f, 24, client, "eMarketplace",
				"Online shop", "Develop of the Webpage");
		credAnalistOneBank.generateWeddingCreditSolicitation(542356789, 3000, 0.16f, 12, client3, "Hawai", client,
				client2, new Date());
		credAnalistEBank.generateTravelCreditSolicitation(1234561234, 2500, 0.1f, 12, client2, "Amsterdam", new Date(),
				new Date());
		credAnalistOneBank.generateHomeMortgageCreditSolicitation(234512345, 30000, 0.02f, 48, client2, 824,
				"PrincipalStreet");
		credAnalistOneBank.generateStudentCreditSolicitation(789012346, 3000, 0.2f, 12, client, "Peter Wood", 9945,
				"System Engineer", 5);

		// Credit Manager of each bank evaluates the score of the credits
		credManagerOneBank.evaluateCredits();
		credManagerEBank.evaluateCredits();

		// Financial Institutions
		logger.info("---CreditOneBank information---");
		logger.info(creditOneBank);
		logger.info("---eBank information---");
		logger.info(eBank);

		// Using the Functional Interfaces
		// 1-Contactable
		creditOneBank.getEmployees().forEach(emp -> emp.sendEmail());
		// 2-Invertible
		client.getCredits().forEach(cred -> cred.invest(20));
		// 3-ISignatory
		creditOneBank.getEmployees().forEach(emp -> logger.info(emp.sign()));
		// 4-IInsurance, the use is in the method calculateCost of CompoundInsurance
		// 5-ListToDouble
		ListToDouble<Credit> getTotalCreditAmount = CredList -> CredList.stream().mapToDouble(cred -> cred.getAmount())
				.sum();
		ListToDouble<Employee> getSalarySum = EmployeeList -> EmployeeList.stream().mapToDouble(emp -> emp.getSalary())
				.sum();
		logger.info(getSalarySum.fromListToDouble(creditOneBank.getEmployees()));
		logger.info(getTotalCreditAmount.fromListToDouble(creditOneBank.getCredits()));
	}
}
