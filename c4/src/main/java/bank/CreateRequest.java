package bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateRequest {
	String owner;
	String name;
	int balance;
}
