package com.computervision;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class CameraViewFragment extends Fragment implements CvCameraViewListener2
{
	private static final String TAG = "CameraViewFragment";
	private CameraBridgeViewBase mOpenCvCameraView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_computer_vision,
				container, false);
		
		Log.i(TAG, "called onCreate");
		super.onCreate(savedInstanceState);
		getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		getActivity().setContentView(R.layout.fragment_computer_vision);

		mOpenCvCameraView = (CameraBridgeViewBase) getActivity().findViewById(R.id.camera_view);
		mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
		mOpenCvCameraView.setCvCameraViewListener(this);
		return rootView;
	}

	public CameraViewFragment()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	@Override
	public void onPause()
	{
		super.onPause();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	@Override
	public void onResume()
	{
		super.onResume();
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_8, this.getActivity(),
				mLoaderCallback);
	}

	@Override
	public void onCameraViewStarted(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCameraViewStopped()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mat onCameraFrame(CvCameraViewFrame inputFrame)
	{
		// TODO Auto-generated method stub
		return inputFrame.rgba();
	}
	
	private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this.getActivity())
	{
		@Override
		public void onManagerConnected(int status)
		{
			switch (status)
			{
			case LoaderCallbackInterface.SUCCESS:
			{
				Log.i(TAG, "OpenCV loaded Successfully");
				mOpenCvCameraView.enableView();
			}
				break;
			default:
			{
				super.onManagerConnected(status);
			}
				break;
			}
		}
	};

}
