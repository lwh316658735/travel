package com.travel.ac.factory;

import android.os.Process;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author jollye
 * 
 */
public class PriorityThreadFactory implements ThreadFactory
{
	private final String		mName;
	private final int			mPriority;
	private final AtomicInteger	mNumber	= new AtomicInteger();

	public PriorityThreadFactory(String name, int priority)
	{
		mName = name;// �̳߳ص�����
		mPriority = priority;//�̳߳ص����ȼ�
	}

	@Override
	public Thread newThread(Runnable r)
	{
		return new Thread(r, mName + "-" + mNumber.getAndIncrement()) {
			@Override
			public void run()
			{
				// �����̵߳����ȼ�
				Process.setThreadPriority(mPriority);
				super.run();
			}
		};
	}
}
