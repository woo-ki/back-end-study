package com.koreait.contact3.command;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

public interface ContactCommand {
	public void execute(AbstractApplicationContext ctx , Model model);
}
