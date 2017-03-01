using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNZoomApiWrapper
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNZoomApiWrapperModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNZoomApiWrapperModule"/>.
        /// </summary>
        internal RNZoomApiWrapperModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNZoomApiWrapper";
            }
        }
    }
}
