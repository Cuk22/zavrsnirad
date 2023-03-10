package com.iktpreobuka.project.security;

import com.iktpreobuka.project.security.Views.Private;
import com.iktpreobuka.project.security.Views.Public;

public class Views {
	public static class Public {}
	public static class Private extends Public {}
	public static class Admin extends Private {}
}
