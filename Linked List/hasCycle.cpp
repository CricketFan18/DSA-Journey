struct ListNode 
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) 
    {
        if(head==nullptr)
        return false;
        bool flag=false;
        ListNode *slow=head;
        ListNode *fast=head;
        while(fast!=nullptr && fast->next!=nullptr)
        {
            slow=slow->next;
            fast=fast->next->next;
            if(slow==fast) return true;
        }
        return false;        
    }
};