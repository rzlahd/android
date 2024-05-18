        DatabaseReference mMessagesRef;
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mMessagesRef = mDatabase.child("users");
        ValueEventListener mMessagesListener;
        mMessagesListener = new ValueEventListener() {@Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // New data at this path. This method will be called after every change in the
                // data at this path or a subpath.

                // Get the data as Message objects
                Log.d(TAG, "Number of messages: " + dataSnapshot.getChildrenCount());
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot\

                    Users dat = child.getValue(Users.class);
                    Users user = new Users(dat.getname(),dat.getusername(),dat.getemail());

                    coursesArrayList.add(user.getemail());
                    arrayAdapter.notifyDataSetChanged();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Could not successfully listen for data, log the error
                Log.e(TAG, "messages:onCancelled:" + error.getMessage());
            }
        };
        mMessagesRef.addValueEventListener(mMessagesListener);
        lv.setAdapter(arrayAdapter);
