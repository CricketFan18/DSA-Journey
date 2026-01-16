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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) 
    {
        if(list1==nullptr)
        return list2;
        if(list2==nullptr)
        return list1;

        ListNode *head=nullptr;
        ListNode *temp=head;
        while(list1!=nullptr && list2!=nullptr) 
        {
            ListNode *t=list1;
            if(list1->val < list2->val)
            {
                t=list1;
                list1=list1->next;                
            }
            else
            {
                t=list2;
                list2=list2->next;
            }  

            if(head==nullptr)
            {
                head=t;
                temp=t;
            }
            else
            {
                temp->next=t;
                temp=temp->next;
            }
            
        }

        if(list1==nullptr)
        {
            temp->next=list2;
        }
        else
        {
            temp->next=list1;
        }
        return head;              

    }
};