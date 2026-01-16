#include<bits/stdc++.h>
struct ListNode 
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverse(ListNode* head)
    {
        ListNode *q=nullptr,*r=nullptr,*p=head;
        while(p!=nullptr)
        {
            r=q;
            q=p;
            p=p->next;
            q->next=r;
        }
        return q;
    }
    bool isPalindrome(ListNode* head) 
    {
        ListNode *slow=head;
        ListNode *fast=head;
        while(fast!=nullptr && fast->next!=nullptr)
        {
            slow=slow->next;
            fast=fast->next->next;
        }            
        ListNode *temp=head;
        ListNode *half=reverse(slow);
        if(fast==nullptr)
        {
            while(half!=nullptr)
            {
                if(half->val!=temp->val) return false;
                half=half->next;
                temp=temp->next;
            }
            return true;
        }
        else
        {            
            while(half!=slow)
            {
                if(temp->val!=half->val) return false;
                temp=temp->next;
                half=half->next;
            }
            return true;
        }
        return false;
   }
};