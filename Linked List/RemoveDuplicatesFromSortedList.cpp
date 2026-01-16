#include<bits/stdc++.h>
struct ListNode 
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution 
{
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* temp=head;
        while(temp!=nullptr)
        {
            int num=temp->val;
            ListNode *repeat=temp->next;
            while(repeat!=nullptr && repeat->val == num)
            {
                temp->next=repeat->next;
                repeat=repeat->next;
            }
            temp=temp->next;
        }
        return head;        
    }
};