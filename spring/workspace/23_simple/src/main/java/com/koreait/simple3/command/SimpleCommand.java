package com.koreait.simple3.command;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

public interface SimpleCommand {
	
	public void execute(AbstractApplicationContext ctx, Model model);
}
