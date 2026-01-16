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

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) 
    {
        ListNode* t1=l1;
        ListNode* t2=l2;
        ListNode *sumlist=new ListNode(-1);
        int carry=0;
        int sum=0;
        ListNode* t=sumlist;
        while(t1!=nullptr || t2!=nullptr)
        {
            sum=carry;
            if(t1!=nullptr) sum+=t1->val;
            if(t2!=nullptr) sum+=t2->val;
            carry=sum/10;
            sum%=10;
            ListNode* newnode=new ListNode(sum);
            t->next=newnode;
            t=newnode;    
            if(t1!=nullptr) t1=t1->next;
            if(t2!=nullptr) t2=t2->next;
        }
        if(carry==1)
        {
            ListNode *last=new ListNode(carry);
            t->next=last;
        }
        return sumlist->next;

    }
};