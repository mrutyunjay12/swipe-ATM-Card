package com.api.context;

import org.springframework.stereotype.Component;

@Component
public class UserTestContextProvider {
	private static final ThreadLocal<UserTestContext> userThreadLocal = new TestContextLocal();

	static final class TestContextLocal extends ThreadLocal<UserTestContext> {

	@Override
	protected UserTestContext initialValue() {
	return new UserTestContext();
	}
	}

	public static UserTestContext get() {
	return userThreadLocal.get();
	}

	}


	


