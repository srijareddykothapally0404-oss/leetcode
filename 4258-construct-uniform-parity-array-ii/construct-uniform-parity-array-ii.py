class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        mino=float('inf')
        odd=False
        for x in nums1:
            if x%2==1:
                odd=True
                mino=min(mino,x)
        if not odd:
            return True
        ev=True
        od=True
        for x in nums1:
            if x%2==1:
                if x==mino:
                    ev=False
            else:
                if mino>=x:
                    od=False
        return ev or od                
            