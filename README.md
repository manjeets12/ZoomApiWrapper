
# react-native-zoom-api-wrapper

## Getting started

`$ npm install react-native-zoom-api-wrapper --save`

### Mostly automatic installation

`$ react-native link react-native-zoom-api-wrapper`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-zoom-api-wrapper` and add `RNZoomApiWrapper.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNZoomApiWrapper.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNZoomApiWrapperPackage;` to the imports at the top of the file
  - Add `new RNZoomApiWrapperPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-zoom-api-wrapper'
  	project(':react-native-zoom-api-wrapper').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zoom-api-wrapper/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-zoom-api-wrapper')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNZoomApiWrapper.sln` in `node_modules/react-native-zoom-api-wrapper/windows/RNZoomApiWrapper.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNZoomApiWrapper;` to the usings at the top of the file
  - Add `new RNZoomApiWrapperPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNZoomApiWrapper from 'react-native-zoom-api-wrapper';

// TODO: What to do with the module?
RNZoomApiWrapper;
```
  "# ZoomApiWrapper" 
