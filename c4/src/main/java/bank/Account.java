package bank;

import lombok.Data;

@Data
public class Account {
	int aid;
	String owner;
	String name;
	int balance;
}
