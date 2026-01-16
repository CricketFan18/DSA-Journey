 #include<bits/stdc++.h>
struct ListNode 
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution{
    ListNode* rotateRight(ListNode* head, int k) 
    {
        if(head==nullptr) return head;
        ListNode* move=head;
        for(int i=1;i<=k;i++)
        {
            move=move->next;
            if(move==nullptr)
            {
                k=k%i;
                i=0;
                move=head;
            }
        }
        ListNode* temp=head;
        while(move->next!=nullptr)
        {
            temp=temp->next;
            move=move->next;
        }
        move->next=head;
        head=temp->next;
        temp->next=nullptr;
        return head;
    }
};