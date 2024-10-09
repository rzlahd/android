public void InterstitialAd_load(){
      AdRequest adRequest = new AdRequest.Builder().build();

      InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
        new InterstitialAdLoadCallback() {
      @Override
      public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
        // The mInterstitialAd reference will be null until
        // an ad is loaded.
        mInterstitialAd = interstitialAd;
        Log.i(TAG, "onAdLoaded");
      }

      @Override
      public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
        // Handle the error
        Log.i(TAG, loadAdError.getMessage());
        mInterstitialAd = null;
      }
    });
}

public static void showAd(){
if (mInterstitialAd != null) {
  mInterstitialAd.show(MyActivity.this);
}
