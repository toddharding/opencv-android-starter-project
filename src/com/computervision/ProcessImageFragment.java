package com.computervision;

import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.core.Mat;

public class ProcessImageFragment extends CameraViewFragment
{

	/**
	 * To process the camera frame use the inputFrame variable
	 * in this method, call inputFrame.rgba() to get
	 * a colour frame.
	 */
	@Override
	public Mat onCameraFrame(CvCameraViewFrame inputFrame)
	{
		// Get the Colour Frame
		Mat myFrame = inputFrame.rgba();
		
		/**
		 * Place your image processing code here
		 */
		
		// Return the processed frame 
		return myFrame;
	}

}
