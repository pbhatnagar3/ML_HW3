import sys
if __name__ == "__main__":
	filename = sys.argv[1]
	print filename
	if sys.argv[2] == 'real':
		attribute_type = 'real'
	else:
		attribute_type = '{0, 1}'

	f = open(filename, 'r')
	lines = f.readlines()
	f.close()

	f = open(filename.replace('.txt', '').split('-')[0] + '-labels.txt', 'r')
	label_list = f.readlines();
	f.close()
	
	num_attributes = len(lines[0].split(','))
	# print num_attributes
	
	f = open(filename.replace('.txt', '.arff'), 'w')
	f.write('@relation ' + filename.replace('.txt', '') + '\n')
	f.write('\n' * 3)
	for i in xrange(num_attributes):
		f.write('@attribute ' + 'attr' + str(i) + ' ' + attribute_type +' \n')

	f.write('@attribute ' + 'RESULT {g, b} \n' )
	f.write('\n' * 3)
	f.write('@data\n')
	for i in xrange(len(lines)):
		f.write(lines[i].rstrip() + ', ' + label_list[i])   

	f.close()


