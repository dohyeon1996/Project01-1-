package project01.ver08;

import java.util.Scanner;
public class MenuSelectException extends Exception {
	public MenuSelectException () {
		super("1~6까지만 입력하세요");
	}
	
}
