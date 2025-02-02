import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class challenge {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

        int lStart = s.nextInt();
        int mStart = s.nextInt();

        int lEnd = s.nextInt();
        int mEnd = s.nextInt();

        int lFeed = s.nextInt();
        int mFeed = s.nextInt();

        int lDif = lEnd - lStart;
        int mDif = mEnd - mStart;

        boolean isSame = (lDif < 0 && lDif < 0) || (lDif > 0 && lDif > 0);
        boolean toLeft = isSame ? lDif < 0 : (lFeed < mFeed ? lDif < 0 : mDif < 0);

        boolean result = false;
        int time = 0;
        int crane = 0;
        int lTime = 0;
        int mTime = 0;

        // got to l first then put it to L then next is m ot M
        lTime = Math.abs(crane - lStart) + Math.abs(lDif);
        crane = lEnd;
        time = Math.abs(lTime);
        mTime = Math.abs(crane - mStart) + Math.abs(mDif) + time;
        result |= lTime <= lFeed && mTime <= mFeed;

        // got to m first then put it to M then next is l ot L
        crane = 0;
        mTime = Math.abs(crane - mStart) + Math.abs(mDif);
        crane = mEnd;
        time = Math.abs(mTime);
        lTime = Math.abs(crane - lStart) + Math.abs(lDif) + time;
        result |= lTime <= lFeed && mTime <= mFeed;

        if (lStart != mStart) {
            // we bring l to m then put l to L then go back to m then M
            crane = 0;
            lTime = Math.abs(lStart - mStart) + Math.abs(crane - lStart);
            crane = mStart;
            lTime += Math.abs(lEnd - crane);
            crane = lEnd;
            time = lTime;
            mTime = Math.abs(crane - mStart) + Math.abs(mDif) + time;
            result |= lTime <= lFeed && mTime <= mFeed;

            // we bring l to m then put to m then M then go back l to L
            crane = 0;
            lTime = Math.abs(lStart - mStart) + Math.abs(crane - lStart); // put l to m
            time = lTime;
            mTime = Math.abs(mDif) + time; // put m to M
            crane = mEnd;
            time = mTime;
            lTime = Math.abs(mDif) + Math.abs(mStart - lEnd) + time; // go back to m to get l then got to L
            result |= lTime <= lFeed && mTime <= mFeed;

            // we bring m to l then put m to M then go back to l then go to L
            crane = 0;
            mTime = Math.abs(lStart - mStart) + Math.abs(crane - mStart);// put m to l
            crane = lStart;
            mTime += Math.abs(mEnd - crane); // put m to M
            crane = mEnd;
            time = mTime;
            lTime = Math.abs(crane - lStart) + Math.abs(lDif) + time; // go back to l to L
            result |= lTime <= lFeed && mTime <= mFeed;

            // we bring m to l then put to l then L then go back m to M
            crane = 0;
            mTime = Math.abs(lStart - mStart) + Math.abs(crane - mStart); // put m to l
            time = mTime;
            lTime = Math.abs(lDif) + time; // put l to L
            crane = lEnd;
            time = lTime;
            mTime = Math.abs(lDif) + Math.abs(lStart - mEnd) + time; // go back to l to get m then go to M
            result |= lTime <= lFeed && mTime <= mFeed;
        }
        System.out.println(result ? "possible" : "impossible");
    }
}
