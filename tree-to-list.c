#include <stdio.h>
#include <stdlib.h>

typedef struct _node node;
struct _node {
  int value;
  node* left;
  node* right;
};

node* transform(node* n, node** rm) {
  if (n == NULL) return NULL;
  *rm = n;
  node* l = transform(n->left, rm);
  node* a = *rm;
  node* r = transform(n->right, rm);
  n->left = NULL;
  n->right = r;
  if (l != NULL) {
    a->right = n;
    return l;
  }
  return n;
}

void print(node* n, int depth) {
  if (n == NULL) {
    printf("E\n");
    return;
  }
  printf("%d\n", n->value);
  int i = 0;
  for (i = 0; i < depth; i++) {
    printf(" ");
  }
  print(n->left, depth+1);
  for (i = 0; i < depth; i++) {
    printf(" ");
  }
  print(n->right, depth+1);
}

int main() {
  node* root = (node*) malloc(sizeof(node));
  root->value = 11;
  node* n4 = (node*) malloc(sizeof(node));
  n4->value = 4;
  n4->left = NULL;
  n4->right = NULL;
  node* n5 = (node*) malloc(sizeof(node));
  n5->value = 5;
  n5->left = NULL;
  n5->right = NULL;
  node* n6 = (node*) malloc(sizeof(node));
  n6->value = 6;
  n6->left = NULL;
  n6->right = NULL;
  node* n7 = (node*) malloc(sizeof(node));
  n7->value = 7;
  n7->left = NULL;
  n7->right = NULL;
  node* n8 = (node*) malloc(sizeof(node));
  n8->value = 8;
  n8->left = NULL;
  n8->right = NULL;
  node* n9 = (node*) malloc(sizeof(node));
  n9->value = 9;
  n9->left = NULL;
  n9->right = NULL;
  node* n10 = (node*) malloc(sizeof(node));
  n10->value = 10;
  n10->left = NULL;
  n10->right = NULL;
  node* n12 = (node*) malloc(sizeof(node));
  n12->value = 12;
  n12->left = NULL;
  n12->right = NULL;
  //---------
  root->left = n9;
  root->right = n12;
  n9->left = n5;
  n9->right = n10;
  n5->left = n4;
  n5->right = n7;
  n7->left = n6;
  n7->right = n8;

  print(root, 1);
  node* rm = NULL;
  node* n = transform(root, &rm);
  printf("--\n");
  print(n, 1);
}
