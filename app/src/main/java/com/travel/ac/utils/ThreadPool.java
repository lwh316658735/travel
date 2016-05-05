package com.travel.ac.utils;

import com.travel.ac.factory.PriorityThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



// �̳߳ص�ʵ�ַ�ʽ
public class ThreadPool
{
	private static final int	POOL_SIZE		= Runtime.getRuntime()
															.availableProcessors() * 3 + 2;
	private final static int	MAX_POOL_SIZE	= 8;										// �����̳߳ص�����߳���
	private final static int	KEEP_ALIVE_TIME	= 4;										// �����̵߳Ĵ��ʱ��
	private final Executor		mExecutor;
	private static ThreadPool	mThreadPool;

	private ThreadPool()
	{
		// �����̳߳ع���
		ThreadFactory factory = new PriorityThreadFactory("thread-pool",
														  android.os.Process.THREAD_PRIORITY_BACKGROUND);
		// ������������
		BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
		mExecutor = new ThreadPoolExecutor(POOL_SIZE,
											MAX_POOL_SIZE,
											KEEP_ALIVE_TIME,
											TimeUnit.SECONDS,
											workQueue,
											factory);
	}

	public static ThreadPool instance()
	{
		if (mThreadPool == null)
		{
			synchronized (ThreadPool.class)
			{
				if (mThreadPool == null)
				{
					mThreadPool = new ThreadPool();
				}
			}
		}
		return mThreadPool;
	}

	// ���̳߳���ִ���߳�
	public void submit(Runnable command)
	{
		mExecutor.execute(command);
	}
}
