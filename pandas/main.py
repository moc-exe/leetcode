import pandas as pd

'''
a few leetcode exercises to practice the pandas libary basic operations, i think they are all ez-tier
'''


# 1 https://leetcode.com/problems/create-a-dataframe-from-list/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def createDataframe(student_data: list[list[int]]) -> pd.DataFrame:
    
    frame_data = {
        'student_id': [student[0] for student in student_data],
        'age': [student[1] for student in student_data]          
    }
    
    return pd.DataFrame(frame_data)

# 2 https://leetcode.com/problems/get-the-size-of-a-dataframe/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def getDataframeSize(players: pd.DataFrame) -> list[int]:
    return list(players.shape)

# 3 https://leetcode.com/problems/display-the-first-three-rows/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    return employees.head(3)

# 4 https://leetcode.com/problems/select-data/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    return students.loc[students['student_id'] == 101, ['name','age']]

# 5 https://leetcode.com/problems/create-a-new-column/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    employees['bonus'] = employees['salary'] * 2
    return employees

# 6 https://leetcode.com/problems/drop-duplicate-rows/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    return customers.drop_duplicates(subset=['email'], keep='first', inplace=False)

# 7 https://leetcode.com/problems/drop-missing-data/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def dropMissingData(students: pd.DataFrame) -> pd.DataFrame:
    return students.dropna(how = 'any', subset = ['name'], inplace=False)

# 8 https://leetcode.com/problems/modify-columns/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def modifySalaryColumn(employees: pd.DataFrame) -> pd.DataFrame:
    
    salaries = employees['salary']
    employees['salary'] = [salary * 2 for salary in salaries]
    return employees

# 9 https://leetcode.com/problems/rename-columns/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
        return students.rename(
                columns={
                    'id' : 'student_id',
                    'first' : 'first_name',
                    'last' : 'last_name',
                    'sage' : 'age_in_years'
                }          
            )


# 10 https://leetcode.com/problems/change-data-type/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def changeDatatype(students: pd.DataFrame) -> pd.DataFrame:

    students['grade'] = students['grade'].astype(int)
    return students

# 11 https://leetcode.com/problems/change-data-type/submissions/1494537613/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:

    products['quantity'].fillna(value=0, inplace=True)
    return products

# 12 https://leetcode.com/problems/reshape-data-concatenate/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def concatenateTables(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
        
    return pd.concat([df1,df2], join='inner')

# 13 https://leetcode.com/problems/reshape-data-pivot/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata


def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:


    return pd.pivot_table(
        data=weather,
        values='temperature',
        index= 'month',
        columns= ['city']
    )

# 14 https://leetcode.com/problems/reshape-data-melt/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata

def meltTable(report: pd.DataFrame) -> pd.DataFrame:

    return report.melt(
        id_vars='product',
        var_name='quarter',
        value_vars=['quarter_1','quarter_2','quarter_3','quarter_4'],
        value_name='sales'
    )

# 15 https://leetcode.com/problems/method-chaining/description/?envType=study-plan-v2&envId=introduction-to-pandas&lang=pythondata


def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    
    mask = animals['weight'] > 100
    return animals.sort_values('weight', ascending=False).loc[mask, ['name']]
