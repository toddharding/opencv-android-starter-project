opencv-android-starter-project
==============================

OpenCV Android Starter Project

Version 0.1 (this is the initial version and has not been fully tested)

##Prerequisites
* Eclipse must be installed
* You must have an Android Device with a Camera

##How to setup your development environment
1. Download or pull repo
2. Download the OpenCV for Android Library from http://opencv.org/downloads.html
3. Extract the OpenCV library to a folder of your choice
4. Open your eclipse workspace and press File->Import->General->Existing Projects into Workspace, then press next
5. Next to Select root directory, browse to the folder where this project is located and press OK
6. Untick Copy projects into workspace
7. Press finish
8. Press File->Import->General->Existing Projects into Workspace, then press next
9. Next to Select root directory, browse to the folder where you extracted the Android OpenCV libraries to and press next
10. Select only the OpenCV Library from the list
11. Untick Copy projects into workspace
12. Press finish
13. Right click on the computer vision project and then press properties
14. Select Android->Library->Add...
15. Select the OpenCV Library and press OK
16. Press OK
17. Attempt to run the application, you should see a camera feed

##Troubleshooting
###Ubuntu 14.04
you may be required to install the lib32zl package



##How to use the code
open the ProcessImageFragment.java file you will see this:

```Java
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
```
Place your image processing code in the OnCameraFrame method



