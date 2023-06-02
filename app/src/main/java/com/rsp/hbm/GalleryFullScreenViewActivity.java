//package com.rsp.ohb;
//
//import static com.fun.sugar.dating.utils.Utils.getArrayList;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.WindowManager;
//
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.viewpager2.widget.ViewPager2;
//
//import com.fun.sugar.dating.databinding.ActivityGalleryFullScreenViewBinding;
//import com.fun.sugar.dating.models.GalleryFullScreenAdapter;
//import com.fun.sugar.dating.models.user_data.User;
//import com.fun.sugar.dating.utils.Utils;
//import com.rsp.ohb.databinding.ActivityGalleryFullScreenViewBinding;
//
//import org.json.JSONArray;
//
//import java.util.List;
//
//public class GalleryFullScreenViewActivity extends BaseActivity {
//    ActivityGalleryFullScreenViewBinding binding;
//
//    public static void start(Activity activity, User user) {
//        activity.startActivity(new Intent(activity, GalleryFullScreenViewActivity.class));
////        imageList = getArrayList(user.userProfileData.gallery);
//        mUser = user;
//    }
//
//
//
//
//    public static void start(Activity activity, User user, int position) {
//        activity.startActivity(new Intent(activity, GalleryFullScreenViewActivity.class));
////        imageList = getArrayList(user.userProfileData.gallery);
//        mUser = user;
//        pos = position;
//    }
//
//    private static List<String> imageList;
//    private static User mUser;
//    private static int pos = -1;
//
//    BaseActivity mContext;
//    GalleryFullScreenAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityGalleryFullScreenViewBinding.inflate(getLayoutInflater());
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
//
//        mContext = this;
//        setContentView(binding.getRoot());
//
//        mAdapter = new GalleryFullScreenAdapter(GalleryFullScreenViewActivity.this, imageList);
//
//
//        binding.backBtn.setOnClickListener(view -> onBackPressed());
//        binding.viewPager.setAdapter(mAdapter);
//        binding.viewPager.setClipChildren(false);
//        binding.viewPager.setClipToPadding(false);
//        binding.viewPager.setOffscreenPageLimit(imageList.size());
//        binding.viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//        binding.textView.setText("1/" + imageList.size());
//
//        if (pos != -1) {
//            binding.viewPager.setCurrentItem(pos, false);
//            binding.textView.setText((pos + 1) + "/" + imageList.size());
//        }
//
//        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                binding.textView.setText((position + 1) + "/" + imageList.size());
//            }
//        });
//
//
//        binding.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(mContext).setMessage("Are you sure to delete?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        int index = binding.viewPager.getCurrentItem();
//                        String targetItem = getArrayList(mUser.userProfileData.gallery).get(index);
//                        mContext.showProgress("Deleting Picture");
//                        imageList.remove(targetItem);
//                        mUser.userProfileData.gallery = new JSONArray(imageList);
//                        FirebaseHelper.updateDocument(mUser.uid, mUser, new FirebaseHelper.InsertOperationListener() {
//                            @Override
//                            public void onComplete(User user) {
//                                imageList = getArrayList(user.userProfileData.gallery);
//                                if (imageList.size() == 0) {
//                                    onBackPressed();
//                                } else if (index >= imageList.size()) {
//                                    mAdapter.notifyDataSetChanged();
//                                    try {
//                                        binding.viewPager.setCurrentItem((index - 1), true);
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                    mContext.dismissProgress();
//                                    showToast("Successfully Deleted");
//                                } else {
//                                    mAdapter.notifyDataSetChanged();
//                                    try {
//                                        binding.viewPager.setCurrentItem(index, true);
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                        binding.viewPager.setCurrentItem(index - 1, true);
//                                    }
//                                    mContext.dismissProgress();
//                                    showToast("Successfully Deleted");
//                                }
//
//
//                            }
//
//                            @Override
//                            public void onFailed() {
//                                mContext.dismissProgress();
//                            }
//                        });
//
//                    }
//                }).setNegativeButton("No", null).show();
//            }
//        });
//
//
//    }
//
//    void setData(User user) {
//
//    }
//
//}